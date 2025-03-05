
# ESHOP

Adpro Spring Boot Project


## Tutorial 3

### Principle yang Digunakan

#### Single Responsibility Principle
SRP menyatakan bahwa sebuah class harus memiliki satu dan hanya satu tujuan. Yang dimana MVC Architecture dapat dibilang implement dari SRP. Seperti berikut:
1. Models (Product & Car) memiliki tujuan untuk representasi attribute yang dimiliki sebuah model.
2. Repositories (ProductRepository & Car Repository) handle data untuk ke database
3. Services (ProductService & CarService) berisi logika bisnis.
4. Controllers (ProductController, CarController) memiliki tujuan untuk meng-handle HTTP request

#### Open/Closed Principle (OCP)
OCP prinsip ini menyatakan bahwa software harus terbuka untuk penambahan tetapi tertutup untuk modifikasi.
1. Abstract Class (contoh: ModelAbstract) yang dapat diperluas tanpa mengubah kode yang sudah ada.
2. Antarmuka (contoh: folder RepositoryInterface & ServiceInterface) yang mendefinisikan interface, dapat diimplementasikan selama sesuai dengan kriteria interfacce.

#### Liskov Subtitution Principle (LSP)
LSP menyatakan bahwa object dari superclass harus dapat diubah dengan object dari subclass tanpa mengganggu kebenaran program.
1. Abstract class (ModelAbstract) dapat diextend oleh Product dan Car tanpa merusak isi dari subclass (Product & Car) tersebut.

#### Interface Segregation Principle (ISP)
ISP menyatakan bahwa program seharusnya tidak terpaksa berdepensi dengan interface yang tidak mereka pakai.
1. Membuat folder ServiceInterface yang dimana berisikan interface dasar untuk berbagai method (GET, POST, DELETE, UPDATE) yang dimana nantinya tiap ProductService atau CarService dapat mengambil salah keempat itu dan tidak harus semuanya sesuai yang diinginkan.

#### Dependency Inversion Principle (DIP)
DIP menyatakan bahwa high-level modules seharusnya tidak berdependensi dengan low-level modules, keduanya seharusnya berdependensi dengan abstractions.

1. Spring Boot secara alami mendukung Dependency Inversion Principle (DIP) melalui mekanisme Dependency Injection (DI). DI memungkinkan kita untuk mengandalkan abstraksi (interface) alih-alih langsung bergantung pada implementasi konkret.

2. Spring Boot menyediakan fitur DI melalui IoC (Inversion of Control) container, yang bekerja dengan anotasi seperti:

    @Service → Untuk menandai service layer
    @Repository → Untuk data access layer
    @Component → Untuk bean yang dapat di-manage oleh Spring

Dengan pendekatan ini, kita bisa memisahkan high-level module dari low-level module, memastikan keduanya bergantung pada abstraksi, bukan pada implementasi langsung.

### Keuntungan Menerapkan Prinsip SOLID dalam Projek

1. Mudah Diupdate (OCP)
- Contoh: Menambahkan tipe Item baru (misal: ElectronicProduct) hanya perlu membuat subclass baru tanpa mengubah kode ModelAbstract, ServiceInterface, atau BaseRepository yang sudah ada.
- Hasil: Pengembangan fitur baru lebih cepat dan minim risiko merusak kode yang sudah berjalan.

2. Fleksibel & Dapat Diganti (LSP)

- Contoh: Class Car dan Product bisa digunakan di semua lapisan (service, repository, controller) sebagai Item tanpa menyebabkan error, karena perilakunya konsisten.
- Hasil: Kolaborasi tim lebih mudah karena tidak perlu tahu detail implementasi tiap subclass.

3. Interface Spesifik (ISP)

- Contoh: ProductController hanya bergantung pada ProductService, tidak terpaksa mengimplementasi method CarService yang tidak digunakan.
- Hasil: Kode lebih bersih dan menghindari "interface pollution".

4. Dependensi Mudah di-maintenance (DIP)

- Contoh: Lapisan service menggunakan interface BaseRepository (bukan implementasi langsung), sehingga mudah mengganti database tanpa mengubah service.
- Hasil: Testing lebih mudah dengan mock repository, dan kode lebih modular.

5. Kode Lebih Terstruktur

- Contoh: Pemisahan layer (controller ↔ service ↔ repository) memisahkan tanggung jawab, sehingga debug dan maintenance lebih mudah.

### Kerugian Tidak Menerapkan Prinsip SOLID

1. Kode Kaku & Sulit Diperluas

- Contoh: Jika ProductService langsung bergantung pada class Product (bukan interface pada folder ServiceInterface), menambah Car akan memaksa modifikasi ProductService, berisiko menyebabkan bug.

2. Ketergantungan Tinggi Antar Komponen

- Contoh: Jika ProductController bergantung pada ProductServiceImpl (konkret), mengganti implementasi service akan merusak controller.

3. Duplikasi Kode

- Contoh: Tanpa LSP, mungkin ada pengecekan if (item instanceof Product) di seluruh lapisan, menyebabkan logika berulang.

4. Sulit Diuji

- Contoh: Jika ProductService langsung memanggil database (tanpa interface repository), testing harus menggunakan database nyata, lambat dan rentan error.

5. Technical Debt Menumpuk

- Contoh: Tidak menerapkan ISP bisa membuat interface ProductService memiliki 20+ method, padahal ProductController hanya butuh 5 method. Kode jadi sulit dipahami dan dimodifikasi.



## Tutorial 2

#### Reflection 1
Untuk mengecek code quality issue saya pertama menggunakan Sonar Qube, tetapi untungnya Sonar Qube menunjukan tidak ada issue, sehingga saya menambahkan PMD agar pencarian code quality issue lebih maksimal. Saya mendapatkan 7 issue yang terdiri dari penggunakan import bintang, tidak perlunya modifier public pada class interface product service dan utility class has a non private constructor yang diaman saya suprass warningnya karena terdapat di class main.

#### Reflection 2
Menurut saya pengaplikasian saya sudah memenuhi CI dan CD. Saya sudah mengimplementasikan 5 Github Actions untuk mendukung CI dan CD yang saya gunakan. Salah satunya adalah mengecek unit test setiap kali ada perubahan pada saat push yang dimana saya juga sudah mendapatkan 100% code coverage pada unit test tersebut. Saya juga memili 3 CI yang melihat code quality saya (Scorecard Analysis, SonarQube Analysis, dan PMD). Lalu, untuk CD saya sudah berhasil melakukan deploy di Koyeb setiap ada pembaruan di main.

## Tutorial 1

#### Reflection 1
Dalam refleksi ini, saya mengevaluasi standar pengkodean, prinsip-prinsip clean code, dan praktik pengkodean yang aman yang diterapkan pada proyek Spring Boot saya. Proyek ini mengikuti beberapa prinsip clean code, seperti penggunaan nama yang bermakna, Single Responsibility Principle (SRP), dan prinsip DRY (Don't Repeat Yourself). Dimana yang artinya nama variable dan class memiliki makna yang bermakna dan bertujuan agar dapat dipahami sekali baca. Lalu, setiap function yang saya buat juga hanya memiliki 1 tujuan yang dimana ini memenuhi prinsip SRP. Setelah itu, saya juga tidak memiliki function dengan tujuan sama yang artinya memenuhi prinsip DRY.

#### Reflection 2
1. Menurut saya unit test sangatlah penting untuk mengetest secara langsung class yang sudah kita buat. Ini dapat menghemat waktu kita dibandingkan menjalankannya secara manual dan mencobanya sendiri. Lalu, menurut saya unit test harusnya mengcover semua positif case dan negatif case. Tetapi walaupun kita mencapai 100% code coverage belum tentu hal itu tidak berarti tanpa bug atau tanpa error dikarenakan unit test dibuat oleh developer itu sendiri yang dimana bisa jadi bug didapat saat user menggunakan hal yang tidak terpikirkan oleh developer tersebut.

2. Ini akan melanggar prinsip DRY (Don't Repeat Yourself) dikarenakan prosedurnya akan sama dengan functional test untuk create karena untuk megeyesy product list kita perlu membuat productnya terlebih dahulu dan mengecek jumlah product yang dibuat melalui table. Menurut saya lebih baik menambahkannya di CreateProductFunctionalTest.java yaitu menambahkan jumlah yang dicreate lalu mencoba test jumlah yang telah dibuat dengan mengecek jumlah row pada table.