package DatabaseConnection;



public class Hbase {

    public void startUp() {

        //Configuration config = HBaseConfiguration.create();
/*
        try {
            HTable hTable = new HTable(config, "employee");

            Put p = new Put(Bytes.toBytes("row2001"));

            p.add(Bytes.toBytes("personal"),
                    Bytes.toBytes("name"),Bytes.toBytes("Vivek"));
            p.add(Bytes.toBytes("personal"),
                    Bytes.toBytes("age"),Bytes.toBytes("17"));
            p.add(Bytes.toBytes("contactinfo"),Bytes.toBytes("city"),
                    Bytes.toBytes("Bengaluru"));
            p.add(Bytes.toBytes("contactinfo"),Bytes.toBytes("country"),
                    Bytes.toBytes("India"));
            p.add(Bytes.toBytes("contactinfo"),Bytes.toBytes("email"),
                    Bytes.toBytes("vivek@abcd.com"));

            hTable.put(p);
            hTable.close();

        }
        catch (HBaseIOException e){

        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
