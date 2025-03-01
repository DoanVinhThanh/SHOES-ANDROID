    package com.example.nike;

    import android.content.ContentValues;
    import android.content.Context;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;

    import com.example.nike.Model.AdminCategory;
    import com.example.nike.Model.ProductAdmin;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;

    public class DatabaseHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "ecommerce.db";
        private static final int DATABASE_VERSION = 2;

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createCategoryTable = "CREATE TABLE categories (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT, " +
                    "image TEXT)";

            String createProductTable = "CREATE TABLE products (" +
                    "idProduct INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nameProduct TEXT, " +
                    "priceProduct TEXT, " +
                    "sizeProduct TEXT, " +
                    "idCategory INTEGER, " +
                    "imageUrlProduct TEXT, " +  // 🆕 Thêm cột này để lưu URL ảnh
                    "FOREIGN KEY(idCategory) REFERENCES categories(id))";


            db.execSQL(createCategoryTable);
            db.execSQL(createProductTable);
        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS categories");
            db.execSQL("DROP TABLE IF EXISTS product");
            onCreate(db);
        }

        public long addCategory(String name, String image) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("image", image);
            return db.insert("categories", null, values);
        }
        public String getCategoryNameById(int categoryId) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT name FROM categories WHERE id = ?", new String[]{String.valueOf(categoryId)});
            if (cursor != null && cursor.moveToFirst()) {
                String categoryName = cursor.getString(0);
                cursor.close();
                return categoryName;
            }
            return null;
        }

        public List<AdminCategory> getAllCategories() {
            List<AdminCategory> categories = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM categories", null);

            if (cursor != null && cursor.moveToFirst()) {  // Kiểm tra cursor != null
                do {
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                    String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                    String image = cursor.getString(cursor.getColumnIndexOrThrow("image"));
                    categories.add(new AdminCategory(id, name, image));
                } while (cursor.moveToNext());
                cursor.close();
            }
            return categories;
        }

        public void updateCategory(int id, String name, String image) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("image", image);
            db.update("categories", values, "id = ?", new String[]{String.valueOf(id)});
        }

        public void deleteCategory(int id) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete("categories", "id = ?", new String[]{String.valueOf(id)});
        }
        public List<ProductAdmin> getAllProducts() {
            List<ProductAdmin> productList = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM products", null);

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow("idProduct"));
                    String name = cursor.getString(cursor.getColumnIndexOrThrow("nameProduct"));
                    String price = cursor.getString(cursor.getColumnIndexOrThrow("priceProduct"));
                    String sizeString = cursor.getString(cursor.getColumnIndexOrThrow("sizeProduct"));
                    List<String> sizes = List.of(sizeString.split(","));
                    int idCategory = cursor.getInt(cursor.getColumnIndexOrThrow("idCategory"));
                    String imageUrl = cursor.getString(cursor.getColumnIndexOrThrow("imageUrlProduct")); // 🆕 Lấy ảnh

                    productList.add(new ProductAdmin(id, name, price, sizes, idCategory, imageUrl));
                } while (cursor.moveToNext());
                cursor.close();
            }
            return productList;
        }
        public AdminCategory getCategoryById(int categoryId) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT id, name FROM categories WHERE id = ?", new String[]{String.valueOf(categoryId)});

            if (cursor != null && cursor.moveToFirst()) {
                AdminCategory category = new AdminCategory();
                category.setId(cursor.getInt(0));
                category.setName(cursor.getString(1));
                cursor.close();
                return category;
            }
            return null;
        }

        public void addProduct(ProductAdmin product) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nameProduct", product.getNameProduct());
            values.put("priceProduct", product.getPriceProduct());
            values.put("sizeProduct", String.join(",", product.getSizeProduct()));
            values.put("idCategory", product.getIdCategory());
            values.put("imageUrlProduct", product.getImageUrlProduct());

            db.insert("products", null, values);
            db.close();
        }


        public void updateProduct(ProductAdmin product) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nameProduct", product.getNameProduct());
            values.put("priceProduct", product.getPriceProduct());
            values.put("sizeProduct", String.join(",", product.getSizeProduct()));
            values.put("idCategory", product.getIdCategory());
            values.put("imageUrlProduct", product.getImageUrlProduct()); // 🆕 Cập nhật ảnh

            db.update("products", values, "idProduct = ?", new String[]{String.valueOf(product.getIdProduct())});
            db.close();
        }


        public void deleteProduct(int idProduct) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete("products", "idProduct = ?", new String[]{String.valueOf(idProduct)});
        }
        public ProductAdmin getProductById(int id) {
            SQLiteDatabase db = this.getReadableDatabase();
            ProductAdmin product = null;

            Cursor cursor = db.rawQuery("SELECT * FROM products WHERE idProduct = ?", new String[]{String.valueOf(id)});
            if (cursor.moveToFirst()) {
                String name = cursor.getString(cursor.getColumnIndexOrThrow("nameProduct"));
                String price = cursor.getString(cursor.getColumnIndexOrThrow("priceProduct"));
                String sizesString = cursor.getString(cursor.getColumnIndexOrThrow("sizeProduct"));
                int categoryId = cursor.getInt(cursor.getColumnIndexOrThrow("idCategory"));
                String imageUrl = cursor.getString(cursor.getColumnIndexOrThrow("imageUrlProduct")); // 🆕 Lấy ảnh

                List<String> sizes = Arrays.asList(sizesString.split(","));

                product = new ProductAdmin(id, name, price, sizes, categoryId, imageUrl);
            }
            cursor.close();
            db.close();
            return product;
        }

    }