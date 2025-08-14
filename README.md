# API Transactions
Aplikasi API sederhana ini dibuat untuk persyaratan rekrutmen. API ini menggunakan format JSON dan menggunakan method HTTP RESTful API. Data disimpan di database PostgreSQL. Hanya ada satu endpoint yang digunakan disini, dengan menggunakan method GET, dan dikembalikan dalam bentuk list array. Endpoint tersebut mengembalikan data berupa daftar transaksi yang sudah disesuaikan dengan ketentuan soal yang diberikan. Aplikasi ini menggunakan spring boot dan menggunakan maven sebagai builder aplikasi.

# How To ?
## Restore Database
1. Restore database menggunakan script berikut di `command prompt`. file database ada di dalam folder `database`\
   `pg_restore --host "localhost" --port "5432" --username "postgres" --no-password --dbname [nama_database_baru] --verbose [lokasi_file_database]`\
2. Di dalam database, sudah terisi dummy data yang dapat digunakan untuk mengambil data di database

## Compile aplikasi
1. Jalankan script `mvn clean package` di `command prompt` untuk build aplikasi yang ada di dalam project ids-test
2. Lalu akan muncul folder `target` di dalam folder target tersebut, terdapat aplikasi `onlinetest-0.0.1-SNAPSHOT.jar` yang bisa digunakan untuk menjalankan aplikasi

## Jalankan Aplikasi
1. Jalankan script `java -jar onlinetest-0.0.1-SNAPSHOT.jar` di `command prompt` dan tunggu sampai aplikasi berjalan dengan sempurna
2. Lalu masukkan endpoint `http://127.0.0.1:8080/api/transactions` untuk mendapatkan data
