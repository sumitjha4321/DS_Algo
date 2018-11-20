package functional_programming_devoxx;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.function.Consumer;
import java.util.stream.Stream;

interface OrderRepo {
    Stream<Order> findAllOrders();
}


class FileExporter {
    //protected abstract void writeContent(Writer writer) throws IOException;

    public File exportFile(String fileName, Consumer<Writer> writerConsumer) throws IOException {
        File file = new File(fileName);
        try (Writer writer = new FileWriter(file)) {
            writerConsumer.accept(writer);
        }
        return file;
    }
}

class OrderExporter {

    OrderRepo orderRepo;

    protected void writeContent(Writer writer) throws IOException {
        writer.write("orderId,date");
        orderRepo.findAllOrders()
                .map(order -> order.getId() + "," + order.getCreationDate());
               // .forEach(writer::write);
    }

}


class Client {

    public  void main(String[] args) {
        FileExporter fileExporter = new FileExporter();
        OrderExporter orderExporter = new OrderExporter();

        //fileExporter.exportFile("orders.csv", writer -> orderExporter.writeContent(writer));

        //fileExporter.exportFile("users.vsv", writer -> )





    }

}
