package com.saad.Java3Monolithic.repository;

import com.saad.Java3Monolithic.repository.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * !!! DİKKAT !!!
 * Bu interface bir repository sınıfıdır. Bu nedenle Spring sınıfların analiz ederken
 * üzerinde bulunan annotaiton lara bakarak onların instance larını oluşturur.
 * Buraya mutlaka @Repository annotaiton ını eklemeyi unutmayın.
 */
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    /**
     * !! DİKKAT !!
     *  Repository sınıfları içinde sorgu yazmak için özel kelimeleri kullanıyorsunuz.
     *  1- find : kelimesi yazılır
     *  2- By :  ne için arayacağınızı belirtir. kullanacağınız entity propertisinin adını yazarsınız.
     *  3- [entity->değişkenadı] : entity değişken adını yazarsınız.
     *  4- method eğer parametre alıyor ise yazılan metne uygun bir
     *  değişken talep edilir. talep edilen değişkenin adı önemli
     *  değildir.
     *  5- son olarakta methodun geri dönüş tipini belirtirsiniz.
     */
    // select * from tblmusteri where username = ?
    Customer findByUsername (String username);
    // select * from tblmusteri where adres = ?
    List<Customer> findByAddress (String address);
    /**
     * Doğum tarihi belibir tarihten büyük olanları getir.
     * GreaterThan
     * LessThan
     * select * from tblmusteri where dogumtarihi > ?
     */
    List<Customer> findByBirthdateGreaterThan(int birthdate);
    /**
     * Adında belli bir karakter aranılan kişileri getir.
     * select * from tblmusteri where ad like '%?%'
     */
    // değişken adını bilerek farklı yazdım. buraya aranılan değişkenini adını
    // yazma mecburiyeti yok.
    List<Customer> findAllByNameLike(String name);
    /**
     * ad ve adresi a ile başlayanlar
     * select * from tblmusteri where ad like 'a%' and adres like 'a%'
     */
    List<Customer> findAllByNameStartingWith(String letter);
    /**
     * and ile birleştirdiğiniz sorgularda sıralama önemlidir.
     */
    List<Customer> findAllByNameStartsWithAndAddressStartingWith(String name, String address);
    Customer findByNameAndSurnameAndTelephone(String name, String surname, String telephone);
    /**
     * sorgularınız size her zaman sonuç dönmez bu nedenle null gelen sonuçlarda alabilirsiniz.
     */
    Optional<Customer> findOptionalByUsername(String username);
    Optional<List<Customer>> findAllOptionalByAddress(String address);
    /**
     * ASC -> A...Z
     * DESC -> Z..A
     * @return
     */
    List<Customer> findByOrderByBirthdate();
    List<Customer> findByOrderByBirthdateDesc();
    Customer findTopByOrderByBirthdateDesc();
    /**
     * ÖNEMLİ !!!!!
     * Eğer sorgunuz birden fazla kayıt dönüyorsa tekli sonuz yazmayın.
     * CompilerTime da sorun olmaz ama kullanırken hata alırsınız.
     *
     * @return
     */
    List<Customer> findTop3ByOrderByBirthdateDesc();
    Optional<List<Customer>> findTop3OptionalByOrderByBirthdateDesc();

    /**
     * select * from tblmusteri where dogumtarihi > ? and dogumtarihi < ?
     */
    List<Customer> findAllByBirthdateBetween(int start, int end);
    List<Customer> findAllByAddressAndBirthdateBetween(String address, int start, int end);

    /**
     * 1- aktif olan müşterileri getir.
     */
//    List<Customer> findAllByIsactive(boolean isactive);// true, false
//    List<Customer> findAllByIsactiveTrue();// aktif kayıtlar
//    List<Customer> findAllByIsactiveFalse();// pasif kayıtlar

    /**
     * 3- ad ve soyadına göre ara ad ve soyad büyük küçük harf duyarlı olmasın
     */
    Optional<List<Customer>> findAllOptionalByNameAndSurname(String Name, String Surname);
    Optional<List<Customer>> findAllOptionalByNameIgnoreCaseAndSurnameIgnoreCase(String name, String surname);

    /**
     * cep telefonu 555 ile başlayanları getir.
     * %555 ->
     */
    Optional<List<Customer>> findAllOptionalByTelephoneLike(String telephone);
    /**
     * 555XXXXXXX
     */
    Optional<List<Customer>> findAllOptionalByTelephoneStartingWith(String telephone);

    /**
     * XXX555XXXX
     */
    Optional<List<Customer>> findAllOptionalByTelephoneContaining(String telephone);
    /**
     * mail adresi gmail olan ankaralı ların listesi
     */
    Optional<List<Customer>> findAllOptionalByEmailContainingAndAddress(String email, String address);


    //JPQL
    @Query("select c from Customer c where c.email= ?1")
    Customer youFindAccordingToEmail(String email);
    @Query("select c from Customer c where c.name=?1 and c.surname=?2")
    Customer findNameSurname(String name, String surname);

    //Native SQL
    @Query(value = "select * from Customer where email = ?1", nativeQuery = true)
    List<Customer> getAccordingToEmail(String email);

    //Using Parameters
    @Query("select c from Customer c where c.name= :name and c.email= :email")
    Customer findByNameAndEmail(
            @Param("email") String customerEmail,
            @Param("name") String customerName);

    Customer findByUsernameAndPassword(String username, String password);
    Optional<Customer> findOptionalByUsernameAndPassword(String username, String password);

    /**
     * Muhammet -> muhammet
     * @param username
     * @param password
     * @return
     */
    @Query("select COUNT(c)>0 from Customer c where UPPER(c.username)=UPPER(?1) and c.password=?2")
    Boolean isExistCustomer(String username,String password);
}
