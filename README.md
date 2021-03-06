# DiabetesDataManagementAP
It's include an android application for diabetes data management.

![2019-03-23-083446_1366x768_scrot](https://user-images.githubusercontent.com/55502819/102106896-2ede0d00-3e42-11eb-8cd9-90aeca2f06e5.png)
![2019-03-23-084156_1366x768_scrot](https://user-images.githubusercontent.com/55502819/102106959-3dc4bf80-3e42-11eb-94a4-684dc4ab423e.png)

Şekil 1)Kullanıcı ve ya doktor girişi.        
Şekil 2)                           Kullanıcı kayıt ekranı.

Uygulama ilk açılışın da temel kullanıcılar için kimlik numarası ve şifre istemektedir. Kullanıcı henüz sisteme kayıtlı değilse kayıt ol düğmesi ile kayıt oluşturma ekranına geçebilir. Burada gerekli olan kimlik numarası, şifre, ad, soyad, cinsiyet gibi bilgileri girerek kaydını tamamlayabilir. Doktorlar için kayıtlar sistem tarafından atanır. Yeni bir kişisel doktor kaydı oluşturmak mümkün değildir.


![2019-03-23-084327_1366x768_scrot](https://user-images.githubusercontent.com/55502819/102107551-e70bb580-3e42-11eb-9f6f-362cc3fc9cd9.png)
![2019-03-23-084341_1366x768_scrot](https://user-images.githubusercontent.com/55502819/102107585-eecb5a00-3e42-11eb-807a-92679383e50e.png)

Şekil 3)Günlük kayıtlar ekranı 

Şekil 4)Günlük Kayıt Ekleme Ekranı

Kullanıcı giriş yaptıktan sonra karşısına günlük kayıtlarını bulabileceği bir ekranla karşılaşır. Bu ekranda dilerse kayıtlarını sağa ve ya sola kaydırarak silebilir, sağ alt bölümdeki düğmeye tıklayarak yeni bir kayıt ekleme ekranına geçebilir. Ekranın sol üst kısmında ki menü işaretine tıklayarak açılan menüden bir şikayet kaydı oluşturabilir daha sonra şikayet kaydına doktordan gelen mesaj ve ya tetkik önerilme isteğinin öğrenebilir, gelen tetkik isteğine tetkik sonucunu cevap olarak gönderebilir.
	Yeni bir günlük kayıt ekleme sekmesinde kullanıcı dilediği bir tarih ve saat seçebilir. Tarih ve saat seçmez ise o anki tarih ve saat  geçerli sayılacaktır. Tarih ve saat bölümünün altında kalan seçenekler düğmesinden açlık kan şekeri, insülin dozu, egzersiz miktarı vb. birçok seçeneği seçip değerini girerek kayıt oluşturabilir.

![2019-03-23-084413_1366x768_scrot](https://user-images.githubusercontent.com/55502819/102107949-5d101c80-3e43-11eb-889b-a433ac128947.png)
![2019-03-23-084506_1366x768_scrot](https://user-images.githubusercontent.com/55502819/102107965-639e9400-3e43-11eb-8767-5e3ca18410ff.png)

Şekil 5) Şikayet bildirim ekranı

Şekil 6) Doktor anasayfa ekranı

Doktor giriş yaptıktan sonra karşısına çıkan ekranda kendisine gelen şikayet kayıtları listelenir. Bu kayıtların her biri muayene olarak geçmektedir. Doktor dilerse karşısındaki kaydı sola kaydırarak muayene bilgilerini güncelleyebilir, sola kaydırır ise kullanıcıya tetkik önerebilir. 


![2019-03-23-084517_1366x768_scrot](https://user-images.githubusercontent.com/55502819/102108221-b4ae8800-3e43-11eb-8fbc-678101224281.png)
![2019-03-23-084529_1366x768_scrot](https://user-images.githubusercontent.com/55502819/102108230-b6784b80-3e43-11eb-8b56-fe10963b8686.png)

Şekil 7) Muayene güncelleme  ekranı 

Şekil 8) Tetkik önerme ekranı

Doktor sola kaydırdığı kayıtların muayene bilgilerini Ana tanı, ek tanı, şikayet, ağırlık, boy, nabız gibi değerleri güncelleyebilir. Sağa kaydırdığında ise tetkik önerme ekranından kullanıcıya tetkik önerebilir.

![2019-03-23-084639_1366x768_scrot](https://user-images.githubusercontent.com/55502819/102108431-fa6b5080-3e43-11eb-8396-d8afd83be7f7.png)

Şekil 9) Önerilen tetkikler ekranı

Kullanıcı tarafına tekrar döndüğümüzde şikayetlerimize karşı istenen tetkikler menü deki tetkikler sekmesinden görülebilir. Kullanıcı bu tetkiklere tetkik sonuçlarını girerek doktora geri yönlendirebilir. 
	Doktor tetkik sonuçlarına göre tanı koyabilir, yeni tetkik önerebilir, tedavi ve gözlemde bulunabilir. Doktor hastanın tedaviye uyup uymadığını takip edebilir. Tedavi sürecinde ilerleme kaydedilemez ise doktor yeniden ilaç ve ya egzersiz önerebilir.

********************************************************************************************

Uygulamaya doktor kaydı yapılamadığı için örnek doktor kayıtları
(1,2,"Uzman","Ahmet","Galip")
(2,3,"Uzman","Yeter","Bicer")
Örnek Hasta kullanıcısı:
(1,2,"ahmet","galip",date,"erkek");

********************************************************************************************

Sıradaki süreçte Activityler fragmentler ile yer değiştirelecektir. Sadece LoginActivity, DoctorActivity ve UserActivity kullanılacaktır. 
Diğer süreçler planlama aşamasındadır...

*******************************************************************************************

MVVM with ROOM, RxJava, DaggerHilt, Retrofit.
