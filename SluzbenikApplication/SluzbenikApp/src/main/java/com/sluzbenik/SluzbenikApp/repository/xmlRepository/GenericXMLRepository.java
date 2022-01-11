package com.sluzbenik.SluzbenikApp.repository.xmlRepository;

import com.sluzbenik.SluzbenikApp.model.vakc_sistem.IdentifiableEntity;
import com.sluzbenik.SluzbenikApp.repository.xmlRepository.id_generator.IdGeneratorInterface;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class GenericXMLRepository<T extends IdentifiableEntity> extends StoreRetrieveXMLRepository {

    private final String packagePath;
    private final String collectionPath;

    public GenericXMLRepository (String packagePath, String collectionPath, IdGeneratorInterface idGeneratorInterface){
        super(idGeneratorInterface);
        this.packagePath = packagePath;
        this.collectionPath = collectionPath;
    }

    public void storeXML(T entity, boolean generateId){
        OutputStream os = new ByteArrayOutputStream();
        Collection col = null;
        XMLResource res = null;

        try {
            System.out.println("[INFO] Retrieving the collection: " + collectionPath);
            col = getOrCreateCollection(collectionPath);

            if (generateId){
                entity.setXmlId(idGenerator.generateId(col.listResources()));
            }

            JAXBContext context = JAXBContext.newInstance(packagePath);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(entity, os);

            String documentId = entity.getXmlId() + ".xml";
            System.out.println("[INFO] Inserting the document: " + documentId);
            res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);

            res.setContent(os);
            System.out.println("[INFO] Storing the document: " + res.getId());

            col.storeResource(res);
            System.out.println("[INFO] Done.");
        } catch(JAXBException | XMLDBException e) {
            e.printStackTrace();
        } finally {
            closeResources(col, res);
        }
    }

    public T retrieveXML(String documentId){
        T entity = null;
        try {
            JAXBContext context = JAXBContext.newInstance(packagePath);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            //noinspection unchecked
            entity = (T) unmarshaller.unmarshal(super.retrieveXML(collectionPath, documentId));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return entity;
    }
}