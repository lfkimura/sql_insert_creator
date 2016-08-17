package factory;

public class SqlInsertFactory {

    private static String sqlInsert = "INSERT INTO  VO_BASE_TABLE(NOME_TITULAR, CPF, VALIDO ) values ('%s','%s', %s);";

    public static String createInsert(String line) {
        String[] fields = line.split(";");
        return String.format(sqlInsert, fields[0], fields[1].replace("-", ""), fields[2]);
    }

}
