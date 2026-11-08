package com.auction.factory;
import com.auction.model.Art;
import com.auction.model.Electronics;
import com.auction.model.Item;
import com.auction.model.Vehicle;

public class ItemFactory {
  private ItemFactory() {}

  /**
     * Phương thức Factory tổng quát nhận tham số động (Dùng khi đọc dữ liệu từ File/Socket/GUI Form).
     *
     * @param type          Loại sản phẩm ("ELECTRONICS", "ART", "VEHICLE")
     * @param id            Mã định danh sản phẩm
     * @param name          Tên sản phẩm
     * @param description   Mô tả sản phẩm
     * @param startingPrice Giá khởi điểm
     * @param extraParam1   Thuộc tính riêng 1 (Brand / Artist / Model)
     * @param extraParam2   Thuộc tính riêng 2 (WarrantyMonths / YearCreated / Mileage)
     * @return Đối tượng Item tương ứng
     */

  public static Item createItem(
              String type,
              String id,
              String name,
              String description,
              double startingPrice,
              String extraParam1,
              int extraParam2) {
    if (type == null || type.trim().isEmpty()){
      throw new IllegalArgumentException("Product type cannot be left blank");
    }
    switch(type.trim().toUpperCase()) {
      case "ELECTRONICS":
        if(extraParam2 < 0) {
          throw new IllegalArgumentException("The warranty period cannot be negative.");
        }
        return new Electronics(id, name, startingPrice, description, extraParam1, extraParam2);

      case "ART" :
        return new Art(id, name, description, startingPrice, extraParam1, extraParam2);

      case "VEHICLE":
        if(extraParam2 < 0) {
          throw new IllegalArgumentException("ODO cannot be negative");
        }
        return new Vehicle(id, name, description, startingPrice, extraParam1, extraParam2);

      default: throw new IllegalArgumentException("Invalid product type: " + type);
    }
  }

  public static Electronics createElectronics(
    String id, String name, String description, double startingPrice, String brand, int warrantyMonth) {
      return (Electronics) createItem("ELECTRONICS", id, name, description, startingPrice, brand, warrantyMonth);
    }

  public static Art createArt(
    String id, String name, String description, double startingPrice, String artist, int yearCreated) {
      return (Art) createItem("ART", id, name, description, startingPrice, artist, yearCreated);
    }

    public static Vehicle createVehicle(
      String id, String name, String description, double startingPrice, String model, int mileage) {
        return (Vehicle) createItem("VEHICLE", id, name, description, startingPrice, model, mileage);
      }
}
