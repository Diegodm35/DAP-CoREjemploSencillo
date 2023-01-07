interface Handler {
    void setNext(Handler next);
    void handler(String request);
}

class BaseHandler implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handler(String request) {
        if (next != null) {
            next.handler(request);
        }
    }
}

class ConcreteHandler1 extends BaseHandler {
    @Override
    public void handler(String request) {
        if (request.equals("1")) {
            System.out.println("Handler1 handled request " + request);
        } else {
            super.handler(request);
        }
    }
}

class ConcreteHandler2 extends BaseHandler {
    @Override
    public void handler(String request) {
        if (request.equals("2")) {
            System.out.println("Handler2 handled request " + request);
        } else {
            super.handler(request);
        }
    }
}

class ConcreteHandler3 extends BaseHandler {
    @Override
    public void handler(String request) {
        if (request.equals("3")) {
            System.out.println("Handler3 handled request " + request);
        } else {
            super.handler(request);
        }
    }
}

class Client {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();

        handler1.setNext(handler2);
        handler2.setNext(handler3);

        handler1.handler("1");
        handler1.handler("2");
        handler1.handler("3");
        handler1.handler("4");
    }
}