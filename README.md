
# ESHOP

Adpro Spring Boot Project

## Tutorial 1

#### Reflection 1
Dalam refleksi ini, saya mengevaluasi standar pengkodean, prinsip-prinsip clean code, dan praktik pengkodean yang aman yang diterapkan pada proyek Spring Boot saya. Proyek ini mengikuti beberapa prinsip clean code, seperti penggunaan nama yang bermakna, Single Responsibility Principle (SRP), dan prinsip DRY (Don't Repeat Yourself). Dimana yang artinya nama variable dan class memiliki makna yang bermakna dan bertujuan agar dapat dipahami sekali baca. Lalu, setiap function yang saya buat juga hanya memiliki 1 tujuan yang dimana ini memenuhi prinsip SRP. Setelah itu, saya juga tidak memiliki function dengan tujuan sama yang artinya memenuhi prinsip DRY.

#### Reflection 2
1. Menurut saya unit test sangatlah penting untuk mengetest secara langsung class yang sudah kita buat. Ini dapat menghemat waktu kita dibandingkan menjalankannya secara manual dan mencobanya sendiri. Lalu, menurut saya unit test harusnya mengcover semua positif case dan negatif case. Tetapi walaupun kita mencapai 100% code coverage belum tentu hal itu tidak berarti tanpa bug atau tanpa error dikarenakan unit test dibuat oleh developer itu sendiri yang dimana bisa jadi bug didapat saat user menggunakan hal yang tidak terpikirkan oleh developer tersebut.

2. Ini akan melanggar prinsip DRY (Don't Repeat Yourself) dikarenakan prosedurnya akan sama dengan functional test untuk create karena untuk megeyesy product list kita perlu membuat productnya terlebih dahulu dan mengecek jumlah product yang dibuat melalui table. Menurut saya lebih baik menambahkannya di CreateProductFunctionalTest.java yaitu menambahkan jumlah yang dicreate lalu mencoba test jumlah yang telah dibuat dengan mengecek jumlah row pada table.