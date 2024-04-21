interface SupportHandler {
      void handleRequest(SupportRequest request);
}

class HardwareSupportHandler implements SupportHandler {
      private SupportHandler nextHandler;

      @Override
      public void handleRequest(SupportRequest request) {
            if (request.getType() == SupportType.HARDWARE) {
                  System.out.println("Hardware support team is handling request #" + request.getId() + ": " + request.getDescription());
            } else if (nextHandler != null) {
                  nextHandler.handleRequest(request);
            }
      }

      public void setNextHandler(SupportHandler nextHandler) {
            this.nextHandler = nextHandler;
      }
}

class SoftwareSupportHandler implements SupportHandler {
      private SupportHandler nextHandler;

      @Override
      public void handleRequest(SupportRequest request) {
            if (request.getType() == SupportType.SOFTWARE) {
                  System.out.println("Software support team is handling request #" + request.getId() + ": " + request.getDescription());
            } else if (nextHandler != null) {
                  nextHandler.handleRequest(request);
            }
      }

      public void setNextHandler(SupportHandler nextHandler) {
            this.nextHandler = nextHandler;
      }
}

class NetworkSupportHandler implements SupportHandler {
      private SupportHandler nextHandler;

      @Override
      public void handleRequest(SupportRequest request) {
            if (request.getType() == SupportType.NETWORK) {
                  System.out.println("Network support team is handling request #" + request.getId() + ": " + request.getDescription());
            } else if (nextHandler != null) {
                  nextHandler.handleRequest(request);
            }
      }

      public void setNextHandler(SupportHandler nextHandler) {
            this.nextHandler = nextHandler;
      }
}

class SupportRequest {
      private int id;
      private String description;
      private SupportType type;

      public SupportRequest(int id, String description, SupportType type) {
            this.id = id;
            this.description = description;
            this.type = type;
      }

      public int getId() {
            return id;
      }

      public String getDescription() {
            return description;
      }

      public SupportType getType() {
            return type;
      }
}

enum SupportType {
      HARDWARE, SOFTWARE, NETWORK
}

public class Ex1 {
      public static void main(String[] args) {
            HardwareSupportHandler hardwareHandler = new HardwareSupportHandler();
            SoftwareSupportHandler softwareHandler = new SoftwareSupportHandler();
            NetworkSupportHandler networkHandler = new NetworkSupportHandler();

            hardwareHandler.setNextHandler(softwareHandler);
            softwareHandler.setNextHandler(networkHandler);

            SupportRequest request1 = new SupportRequest(1, "Printer isn't working", SupportType.HARDWARE);
            SupportRequest request2 = new SupportRequest(2, "Software installation problem", SupportType.SOFTWARE);
            SupportRequest request3 = new SupportRequest(3, "Internet connection issue", SupportType.NETWORK);

            hardwareHandler.handleRequest(request1);
            hardwareHandler.handleRequest(request2);
            hardwareHandler.handleRequest(request3);
      }
}


