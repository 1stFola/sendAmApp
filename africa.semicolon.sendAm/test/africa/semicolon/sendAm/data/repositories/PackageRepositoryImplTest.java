package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.Package;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PackageRepositoryImplTest {

    private PackageRepository packageRepository;

    @BeforeEach
    private void setUp(){
        packageRepository = new PackageRepositoryImpl();
    }

    @Test
    void repositorySaveTest() {
        // Give that there is a package;
        Package aPackage = new Package();

        //when I try to save in the repository ;
        Package savedPackage = packageRepository.save(aPackage);
        // assert that the returned; has an id;
        assertEquals(1, savedPackage.getId());
        // assert that the count is 1;
        assertEquals(1, packageRepository.count());

    }

    @Test
    void repositoryFindByIdTest(){
        Package firstPackage = new Package();
        Package secondPackage = new Package();
        Package thirdPackage = new Package();

        packageRepository.save(firstPackage);
        packageRepository.save(secondPackage);
        packageRepository.save(thirdPackage);

        Package foundPackage = packageRepository.findById(2);

        assertEquals(secondPackage, foundPackage);
        assertEquals(2, foundPackage.getId());
    }

    private void saveThreePackages(){
        Package firstPackage = new Package();
        Package secondPackage = new Package();
        Package thirdPackage = new Package();

        packageRepository.save(firstPackage);
        packageRepository.save(secondPackage);
        packageRepository.save(thirdPackage);
    }

    @Test
    void deleteByIdTest() {
        saveThreePackages();

        packageRepository.delete(2);

        assertEquals(2, packageRepository.count());
    }

    @Test
    void findByIdWorks_afterADeleteTest(){
        saveThreePackages();
        packageRepository.delete(2);

        Package foundPackage = packageRepository.findById(2);
        assertNull(foundPackage);

    }

    @Test

    void saveAfterADelete_givesCorrectPackageIdTest(){
        saveThreePackages();
        packageRepository.delete(1);
        Package savedPackage = packageRepository.save(new Package());
        assertEquals(4,savedPackage.getId());


    }

    @Test

    void deleteByPackageTest(){
        Package firstPackage = new Package();
        Package secondPackage = new Package();
        Package thirdPackage = new Package();

        packageRepository.save(firstPackage);
        packageRepository.save(secondPackage);
        packageRepository.save(thirdPackage);

        packageRepository.delete(secondPackage);

        assertEquals(2, packageRepository.count());
        assertNull(packageRepository.findById(2));
    }

    @Test
    void findAllTest(){
        saveThreePackages();

        List<Package> all = packageRepository.findAll();
        assertEquals(3, all.size());
    }

}