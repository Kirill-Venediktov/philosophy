package chapter6_1;

public class ConnectionManager {
   static private Connection[] connections = new Connection[]{
            Connection.getConnection(),Connection.getConnection(),
            Connection.getConnection(),Connection.getConnection()
    };
    static Connection giveMeSomeConnection(){
        Connection connection;
        for (int i = 0; i< connections.length; i++){
            if (connections[i] == null){
                continue;
            }
            connection = connections[i];
            connections[i] = null;
            return connection;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(giveMeSomeConnection().toString());
        System.out.println(giveMeSomeConnection().toString());
        System.out.println(giveMeSomeConnection().toString());
        System.out.println(giveMeSomeConnection().toString());
        System.out.println(giveMeSomeConnection().toString());

    }
}


class Connection{
    private Connection(){
    }
    static Connection getConnection(){
        Connection connection = new Connection();
        return connection;
    }

    void sayHello(){
        System.out.println("Hello,im Connection");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}