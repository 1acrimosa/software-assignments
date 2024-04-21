import java.util.HashMap;
import java.util.Map;

interface DocumentStorage {
      Document downloadDocument(String documentId);

      void uploadDocument(Document document);

      void editDocument(String documentId, Document newDocument);

      void deleteDocument(String documentId);
}

class Document {
      private String documentId;
      private String title;
      private String content;

      public Document(String documentId, String title, String content) {
            this.documentId = documentId;
            this.title = title;
            this.content = content;
      }

      public String getDocumentId() {
            return documentId;
      }

      public String getTitle() {
            return title;
      }

      public String getContent() {
            return content;
      }
}

interface DocumentStorageProxy extends DocumentStorage {
      void authenticateUser(String username, String password);
}

class ConcreteDocumentStorage implements DocumentStorage {
      private Map<String, Document> documentMap;

      public ConcreteDocumentStorage() {
            this.documentMap = new HashMap<>();
      }

      @Override
      public Document downloadDocument(String documentId) {
            return documentMap.get(documentId);
      }

      @Override
      public void uploadDocument(Document document) {
            documentMap.put(document.getDocumentId(), document);
      }

      @Override
      public void editDocument(String documentId, Document newDocument) {
            documentMap.put(documentId, newDocument);
      }

      @Override
      public void deleteDocument(String documentId) {
            documentMap.remove(documentId);
      }
}

class DocumentStorageProxyImpl implements DocumentStorageProxy {
      private DocumentStorage documentStorage;
      private Map<String, Boolean> loggedInUsers;

      public DocumentStorageProxyImpl(DocumentStorage documentStorage) {
            this.documentStorage = documentStorage;
            this.loggedInUsers = new HashMap<>();
      }

      @Override
      public Document downloadDocument(String documentId) {
            return documentStorage.downloadDocument(documentId);
      }

      @Override
      public void uploadDocument(Document document) {
            documentStorage.uploadDocument(document);
      }

      @Override
      public void editDocument(String documentId, Document newDocument) {
            documentStorage.editDocument(documentId, newDocument);
      }

      @Override
      public void deleteDocument(String documentId) {
            documentStorage.deleteDocument(documentId);
      }

      @Override
      public void authenticateUser(String username, String password) {
            if (isValidCredentials(username, password)) {
                  loggedInUsers.put(username, true);
                  System.out.println("User " + username + " logged in successfully.");
            } else {
                  System.out.println("Invalid credentials. User authentication failed.");
            }
      }

      private boolean isValidCredentials(String username, String password) {
            if (username.contains("username") && password.equals("1234"))
                  return true;
            return false;
      }
}

public class Ex2 {
      public static void main(String[] args) {
            DocumentStorage concreteDocumentStorage = new ConcreteDocumentStorage();
            DocumentStorageProxy documentStorageProxy = new DocumentStorageProxyImpl(concreteDocumentStorage);


            documentStorageProxy.authenticateUser("username", "password");

            Document document = new Document("435", "Science Project", "works, charts, graphs");
            documentStorageProxy.uploadDocument(document);

            Document downloadedDocument = documentStorageProxy.downloadDocument("435");
            System.out.println("Downloaded Document: " + downloadedDocument.getTitle());
      }
}

