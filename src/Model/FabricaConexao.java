package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    private enum Sgbds{
        sqlite,mysql
    }


    private static int MAX_CONNECTIONS=5;

    private static Sgbds SGBD=Sgbds.mysql;
    private static String IP_SERVIDOR="infopguaifpr.com.br:3132";
    private static String NOME_BANCO="tads18_jessica";
    private static String USUARIO="tads18_jessica";
    private static String SENHA="jovens17";

    private static String CON_STRING="jdbc:"+SGBD+":";

    private static Connection[] pool;

    private static FabricaConexao instance = new FabricaConexao();

    private FabricaConexao(){

        if(SGBD == Sgbds.mysql){
            CON_STRING="jdbc:"+SGBD.name()+"://"+IP_SERVIDOR+"/"+NOME_BANCO;
        }else{
            CON_STRING="jdbc:"+SGBD.name()+":"+NOME_BANCO+".sqlite";
        }

        pool = new Connection[MAX_CONNECTIONS];
    }

    public static Connection getConnection() throws SQLException{

        for(int i=0;i<MAX_CONNECTIONS;i++){
            if(instance.pool[i]==null || instance.pool[i].isClosed()){
                instance.pool[i] = DriverManager.getConnection(CON_STRING,USUARIO,SENHA);
                return instance.pool[i];
            }
        }

        throw new SQLException("Máximo de conexões");
    }


}