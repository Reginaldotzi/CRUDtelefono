package edu.umg;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class TelefonoDAO {
    private MongoCollection<Document> collection;

    public TelefonoDAO(String connectionString, String databaseName, String collectionName) {
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        this.collection = database.getCollection(collectionName);
    }

    // Método para insertar un teléfono en la base de datos
    public void insertTelefono(Telefono telefono) {
        Document doc = new Document("marca", telefono.getMarca())
                .append("modelo", telefono.getModelo())
                .append("sistemaOperativo", telefono.getSistemaOperativo())
                .append("tamanoPantalla", telefono.getTamanoPantalla())
                .append("memoriaRAM", telefono.getMemoriaRAM())
                .append("almacenamientoInterno", telefono.getAlmacenamientoInterno())
                .append("tieneCamara", telefono.isTieneCamara())
                .append("resolucionCamara", telefono.getResolucionCamara())
                .append("esSmartphone", telefono.isEsSmartphone())
                .append("imei", telefono.getImei());
        collection.insertOne(doc);
    }

    // Método para leer todos los teléfonos y almacenarlos en un ArrayList
    public List<Telefono> readAllTelefonos() {
        List<Telefono> telefonos = new ArrayList<>();
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Telefono telefono = new Telefono(
                        doc.getString("marca"),
                        doc.getString("modelo"),
                        doc.getString("sistemaOperativo"),
                        doc.getDouble("tamanoPantalla"),
                        doc.getInteger("memoriaRAM"),
                        doc.getInteger("almacenamientoInterno"),
                        doc.getBoolean("tieneCamara"),
                        doc.getInteger("resolucionCamara"),
                        doc.getBoolean("esSmartphone"),
                        doc.getString("imei")
                );
                telefonos.add(telefono);
            }
        } finally {
            cursor.close();
        }
        return telefonos;
    }

    // Método para insertar los teléfonos en una lista enlazada
    public Nodo insertTelefonosEnListaEnlazada() {
        List<Telefono> telefonos = readAllTelefonos();
        if (telefonos.isEmpty()) {
            return null; // Retorna null si no hay teléfonos en la base de datos
        }
        Nodo cabeza = new Nodo(telefonos.get(0)); // Crea el primer nodo con el primer teléfono
        Nodo actual = cabeza; // Nodo actual apunta a la cabeza inicialmente

        // Itera sobre los teléfonos restantes y los agrega como nodos en la lista enlazada
        for (int i = 1; i < telefonos.size(); i++) {
            Nodo nuevoNodo = new Nodo(telefonos.get(i)); // Crea un nuevo nodo con el teléfono correspondiente
            actual.setSiguiente(nuevoNodo); // Establece el siguiente nodo del nodo actual
            actual = nuevoNodo; // Actualiza el nodo actual al nuevo nodo creado
        }

        return cabeza; // Retorna la cabeza de la lista enlazada
    }

    // Método para actualizar un teléfono en la base de datos
    public void updateTelefono(String imei, Telefono nuevoTelefono) {
        Document filter = new Document("imei", imei); // Filtro para encontrar el teléfono por su IMEI
        Document updateDoc = new Document("$set", new Document()
                .append("marca", nuevoTelefono.getMarca())
                .append("modelo", nuevoTelefono.getModelo())
                .append("sistemaOperativo", nuevoTelefono.getSistemaOperativo())
                .append("tamanoPantalla", nuevoTelefono.getTamanoPantalla())
                .append("memoriaRAM", nuevoTelefono.getMemoriaRAM())
                .append("almacenamientoInterno", nuevoTelefono.getAlmacenamientoInterno())
                .append("tieneCamara", nuevoTelefono.isTieneCamara())
                .append("resolucionCamara", nuevoTelefono.getResolucionCamara())
                .append("esSmartphone", nuevoTelefono.isEsSmartphone())
                .append("imei", nuevoTelefono.getImei()));

        collection.updateOne(filter, updateDoc); // Actualiza el teléfono en la base de datos
    }

    // Método para eliminar un teléfono de la base de datos por su IMEI
    public void deleteTelefono(String imei) {
        Document filter = new Document("imei", imei); // Filtro para encontrar el teléfono por su IMEI
        collection.deleteOne(filter); // Elimina el teléfono de la base de datos
    }
}
