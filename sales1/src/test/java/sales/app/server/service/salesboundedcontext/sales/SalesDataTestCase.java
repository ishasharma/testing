package sales.app.server.service.salesboundedcontext.sales;
import sales.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.salesboundedcontext.sales.SalesDataRepository;
import sales.app.shared.salesboundedcontext.sales.SalesData;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import sales.app.shared.salesboundedcontext.sales.Category;
import sales.app.server.repository.salesboundedcontext.sales.CategoryRepository;
import sales.app.shared.salesboundedcontext.sales.Retailer;
import sales.app.server.repository.salesboundedcontext.sales.RetailerRepository;
import sales.app.shared.salesboundedcontext.sales.Distributor;
import sales.app.server.repository.salesboundedcontext.sales.DistributorRepository;
import sales.app.shared.salesboundedcontext.sales.SalesRegion;
import sales.app.server.repository.salesboundedcontext.sales.SalesRegionRepository;
import sales.app.shared.salesboundedcontext.sales.Channel;
import sales.app.server.repository.salesboundedcontext.sales.ChannelRepository;
import sales.app.shared.salesboundedcontext.sales.Brand;
import sales.app.server.repository.salesboundedcontext.sales.BrandRepository;
import sales.app.shared.salesboundedcontext.sales.Material;
import sales.app.server.repository.salesboundedcontext.sales.MaterialRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class SalesDataTestCase extends EntityTestCriteria {

    @Autowired
    private SalesDataRepository<SalesData> salesdataRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
    }

    private SalesData createSalesData() throws SpartanPersistenceException, SpartanConstraintViolationException {
        Category category = new Category();
        category.setCategory("JNp3MiY3OEQMc9oNzS5E1PlmRnRTm5V9HNp2G0QKHJbwCSXjJG");
        Category CategoryTest = categoryRepository.save(category);
        map.put("CategoryPrimaryKey", category._getPrimarykey());
        Retailer retailer = new Retailer();
        Distributor distributor = new Distributor();
        SalesRegion salesregion = new SalesRegion();
        salesregion.setRegionname("DN721WXYNaU3WqdwbZVWKvnhGz7i29D1X3j2lgvkBswFvrhtGI");
        SalesRegion SalesRegionTest = salesregionRepository.save(salesregion);
        map.put("SalesRegionPrimaryKey", salesregion._getPrimarykey());
        distributor.setRegioncode((java.lang.String) SalesRegionTest._getPrimarykey()); /* ******Adding refrenced table data */
        distributor.setLattitude(3300.0d);
        distributor.setLongitude(2900.0d);
        distributor.setDistributorname("yD5p3Gdxg6F8xKUgIbeIBXnR9OvxHtkZaXm5aZppOw6CLk64an");
        Distributor DistributorTest = distributorRepository.save(distributor);
        map.put("DistributorPrimaryKey", distributor._getPrimarykey());
        retailer.setDistributorcode((java.lang.String) DistributorTest._getPrimarykey()); /* ******Adding refrenced table data */
        retailer.setRetailername("YgRrLuLZ8pbjJOuCyYC84bLyDXkjw907ybqKvtCUh7KQWdqbsF");
        Retailer RetailerTest = retailerRepository.save(retailer);
        map.put("RetailerPrimaryKey", retailer._getPrimarykey());
        Channel channel = new Channel();
        channel.setChannel("kFoyrrjWldAt9Gxx6vBJj17MIt3Gptcl2vYYLw2HYNQB2OtCXC");
        Channel ChannelTest = channelRepository.save(channel);
        map.put("ChannelPrimaryKey", channel._getPrimarykey());
        Brand brand = new Brand();
        brand.setBranddesc("GEhb0S7EyEhk9IW6MClFk6aFQcYjnjwlQTgqXyfLkBArdbBoM4");
        brand.setBranddesc("xzssCxiSTkUvAH5YR1x0cm1mIt3iL6rfm1ZMmQBKoQQRVHSY9h");
        brand.setCategoryId((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        Brand BrandTest = brandRepository.save(brand);
        map.put("BrandPrimaryKey", brand._getPrimarykey());
        Material material = new Material();
        material.setBrandcode((java.lang.String) BrandTest._getPrimarykey()); /* ******Adding refrenced table data */
        material.setMaterialdesc("8fFlzoXBS5R3wJCD9PXtJmImTG0ezYwQRJO9ai2jJSguRedeiV");
        Material MaterialTest = materialRepository.save(material);
        map.put("MaterialPrimaryKey", material._getPrimarykey());
        SalesData salesdata = new SalesData();
        salesdata.setMaterialdesc("xGXDuIQMg4wIkvyeUt38KxKdvMKXbwOeWdt40jzJuzxz3hax5T");
        salesdata.setRetailername("Umn5DhJq4Z9ghM3c4LZwZ6ZxoRcqrdBuMv7b3kPy8JV3qv6N1F");
        salesdata.setCategory((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        salesdata.setReatilercode((java.lang.String) RetailerTest._getPrimarykey()); /* ******Adding refrenced table data */
        salesdata.setSalesdate(new java.sql.Date(123456789));
        salesdata.setChannelId((java.lang.String) ChannelTest._getPrimarykey()); /* ******Adding refrenced table data */
        salesdata.setBrandcode((java.lang.String) BrandTest._getPrimarykey()); /* ******Adding refrenced table data */
        salesdata.setBranddesc("epMFf3AMeaHX5kutkTNVNFmRCKknVSpM9BMqyDcsYJ6Y4vizwe");
        salesdata.setSalesmonth(2147483647);
        salesdata.setNetsalesamt(2800.0d);
        salesdata.setSalesinvoicenbr("1Q5Nk8lex5kEo3BPyf2IPOkOYU1aa6vjl3B3BQOR8TIO72CrKF");
        salesdata.setMaterialcode((java.lang.String) MaterialTest._getPrimarykey());
        salesdata.setGrosssalesamt(6000.0d);
        salesdata.setSalesqty(300.0d);
        salesdata.setSalesyear(2147483647);
        salesdata.setEntityValidator(entityValidator);
        return salesdata;
    }

    @Test
    public void test1Save() {
        try {
            SalesData salesdata = createSalesData();
            salesdata.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            salesdata.isValid();
            salesdataRepository.save(salesdata);
            map.put("SalesDataPrimaryKey", salesdata._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CategoryRepository<Category> categoryRepository;

    @Autowired
    private RetailerRepository<Retailer> retailerRepository;

    @Autowired
    private DistributorRepository<Distributor> distributorRepository;

    @Autowired
    private SalesRegionRepository<SalesRegion> salesregionRepository;

    @Autowired
    private ChannelRepository<Channel> channelRepository;

    @Autowired
    private BrandRepository<Brand> brandRepository;

    @Autowired
    private MaterialRepository<Material> materialRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("SalesDataPrimaryKey"));
            SalesData salesdata = salesdataRepository.findById((java.lang.Integer) map.get("SalesDataPrimaryKey"));
            salesdata.setMaterialdesc("3D9jnD9ykst5KqfUzDF9lKaPFHNfox07GDlSnqJsqQGTHBAoqa");
            salesdata.setRetailername("XYqU0kDv5xQG9dn8JSyFJmBGBdLgkLIOxqTU74Mf1W3r9pxKSj");
            salesdata.setSalesdate(new java.sql.Date(123456789));
            salesdata.setVersionId(1);
            salesdata.setBranddesc("kvdfOhdSki77TFHkgkZ4UeVdrdP3uglA736ApCpdYV0kGsKTt0");
            salesdata.setSalesmonth(2147483647);
            salesdata.setNetsalesamt(4600.0d);
            salesdata.setSalesinvoicenbr("l0ZgheeE1lVlUpXrmbJL5HNkqcuWNad3ZZdJbbyNTlBH6aH57X");
            salesdata.setGrosssalesamt(1100.0d);
            salesdata.setSalesqty(100.0d);
            salesdata.setSalesyear(2147483647);
            salesdata.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            salesdataRepository.update(salesdata);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("SalesDataPrimaryKey"));
            salesdataRepository.findById((java.lang.Integer) map.get("SalesDataPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycategory() {
        try {
            java.util.List<SalesData> listofcategory = salesdataRepository.findByCategory((java.lang.String) map.get("CategoryPrimaryKey"));
            if (listofcategory.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByreatilercode() {
        try {
            java.util.List<SalesData> listofreatilercode = salesdataRepository.findByReatilercode((java.lang.String) map.get("RetailerPrimaryKey"));
            if (listofreatilercode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBychannelId() {
        try {
            java.util.List<SalesData> listofchannelId = salesdataRepository.findByChannelId((java.lang.String) map.get("ChannelPrimaryKey"));
            if (listofchannelId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBybrandcode() {
        try {
            java.util.List<SalesData> listofbrandcode = salesdataRepository.findByBrandcode((java.lang.String) map.get("BrandPrimaryKey"));
            if (listofbrandcode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBymaterialcode() {
        try {
            java.util.List<SalesData> listofmaterialcode = salesdataRepository.findByMaterialcode((java.lang.String) map.get("MaterialPrimaryKey"));
            if (listofmaterialcode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("SalesDataPrimaryKey"));
            salesdataRepository.delete((java.lang.Integer) map.get("SalesDataPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateSalesData(EntityTestCriteria contraints, SalesData salesdata) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            salesdata.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            salesdata.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            salesdataRepository.save(salesdata);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "retailername", "7pu7BdDnXtoYEGeIPU4pOhctV4iClTsIiTNPpell2sUxIpa73G5hga03EDAVFCNh1"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 2, "salesdate", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "salesmonth", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "salesyear", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "salesinvoicenbr", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "salesinvoicenbr", "DyQhk43qqGiTmpbE8xsQqt4P1PRnFSiBHYwfUi6GbGH1dL6R8c3UJAcPmKDSqncmE"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "materialdesc", "2AaERoV7L3Fn6up2x5c0D8smbqYdpn19oMBaicYfIMPnF7vhZZLacofmh2RB4HnoB"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "branddesc", "BwhqcJy7dx36UBt1qvFyXXhH3N8Ee0vYtux1GziFoJU0DKXlZ4d5dy6buWWUuoPF1"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 9, "salesqty", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "salesqty", 1.4186942538645367E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "netsalesamt", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "netsalesamt", 1.6661434785922036E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "grosssalesamt", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "grosssalesamt", 1.060727251239383E19d));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                SalesData salesdata = createSalesData();
                java.lang.reflect.Field field = salesdata.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        salesdata.setRetailername(contraints.getNegativeValue().toString());
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 2:
                        field.setAccessible(true);
                        field.set(salesdata, null);
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(salesdata, null);
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(salesdata, null);
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(salesdata, null);
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 6:
                        salesdata.setSalesinvoicenbr(contraints.getNegativeValue().toString());
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 7:
                        salesdata.setMaterialdesc(contraints.getNegativeValue().toString());
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 8:
                        salesdata.setBranddesc(contraints.getNegativeValue().toString());
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 9:
                        field.setAccessible(true);
                        field.set(salesdata, null);
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 10:
                        salesdata.setSalesqty(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(salesdata, null);
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 12:
                        salesdata.setNetsalesamt(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(salesdata, null);
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 14:
                        salesdata.setGrosssalesamt(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                }
            } catch (SpartanIncorrectDataException e) {
                e.printStackTrace();
            } catch (SpartanConstraintViolationException e) {
                e.printStackTrace();
            } catch (SpartanPersistenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
