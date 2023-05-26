package Homework06;

public class Notebook {

    // Заводим аргументы класса
    String model;
    int displayDiagonal;
    // String displayResolution;

    int ramSize;
    int ssdSize;

    // String graphicsProcessor;
    // String processorType;
    // int processorFrecuency;
    // int NumberOfCores;

    String osType;
    String color;

    int price;

    // Заводим заполнение аргументов
    Notebook(String model, int diagonal, int ramSize, int ssdSize, String osType,
            String color, int price) {
        this.model = model;
        displayDiagonal = diagonal;
        this.ramSize = ramSize;
        this.ssdSize = ssdSize;
        this.osType = osType;
        this.color = color;
        this.price = price;
    }

    // Создаем методы получения значений аргументов
    public String getModel() {
        return model;
    }

    public int getDiag() {
        return displayDiagonal;
    }

    public int getRam() {
        return ramSize;
    }

    public int getSsd() {
        return ssdSize;
    }

    public String getOs() {
        return osType;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    // Перегружаем метод ToString()
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Ноутбук ");
        sb.append(this.model);
        sb.append(System.lineSeparator());
        sb.append("Диагональ "+this.displayDiagonal+"''");
        sb.append(System.lineSeparator());
        sb.append("RAM "+this.ramSize+" Gb");        
        sb.append(System.lineSeparator());
        sb.append("SSD "+this.ssdSize+" Gb");        
        sb.append(System.lineSeparator());
        sb.append("OS "+this.osType);
        sb.append(System.lineSeparator());
        sb.append("Цвет "+this.color);
        sb.append(System.lineSeparator());
        sb.append("Цена "+this.price+" руб");
        sb.append(System.lineSeparator());

        return(sb.toString());
    }

}
