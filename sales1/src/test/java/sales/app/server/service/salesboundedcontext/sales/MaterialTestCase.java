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
import sales.app.server.repository.salesboundedcontext.sales.MaterialRepository;
import sales.app.shared.salesboundedcontext.sales.Material;
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
import sales.app.shared.salesboundedcontext.sales.Brand;
import sales.app.server.repository.salesboundedcontext.sales.BrandRepository;
import sales.app.shared.salesboundedcontext.sales.Category;
import sales.app.server.repository.salesboundedcontext.sales.CategoryRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class MaterialTestCase extends EntityTestCriteria {

    @Autowired
    private MaterialRepository<Material> materialRepository;

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

    private Material createMaterial() throws SpartanPersistenceException, SpartanConstraintViolationException {
        Brand brand = new Brand();
        brand.setBranddesc("cdfPvjOAcTBhyVx8DYLn9vbspclGPFYJ99mu9JB5VXjOJH1s6B");
        Category category = new Category();
        category.setCategory("l2qZJHBbIE49Pz8soJp7alx6IvtUpawgmFrgsY7YsG1JEAlFjc");
        Category CategoryTest = categoryRepository.save(category);
        map.put("CategoryPrimaryKey", category._getPrimarykey());
        brand.setBranddesc("o2HOZLwwSYwMPsIL1K8uRb11doKf3EKKvxL4M2tFP4JMwUvkrk");
        brand.setCategoryId((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        Brand BrandTest = brandRepository.save(brand);
        map.put("BrandPrimaryKey", brand._getPrimarykey());
        Material material = new Material();
        material.setBrandcode((java.lang.String) BrandTest._getPrimarykey());
        material.setMaterialdesc("zjA4tCdRCRQDCsIb1Rt9H63s8AFrKUEi8YAe7pTLOtRQERmPrX");
        material.setEntityValidator(entityValidator);
        return material;
    }

    @Test
    public void test1Save() {
        try {
            Material material = createMaterial();
            material.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            material.isValid();
            materialRepository.save(material);
            map.put("MaterialPrimaryKey", material._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private BrandRepository<Brand> brandRepository;

    @Autowired
    private CategoryRepository<Category> categoryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("MaterialPrimaryKey"));
            Material material = materialRepository.findById((java.lang.String) map.get("MaterialPrimaryKey"));
            material.setVersionId(1);
            material.setMaterialdesc("OQE1x3WRups5GwRgyYD5VSTNxuAixYZBC55XB9apDl0BdmICLX");
            material.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            materialRepository.update(material);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBybrandcode() {
        try {
            java.util.List<Material> listofbrandcode = materialRepository.findByBrandcode((java.lang.String) map.get("BrandPrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("MaterialPrimaryKey"));
            materialRepository.findById((java.lang.String) map.get("MaterialPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("MaterialPrimaryKey"));
            materialRepository.delete((java.lang.String) map.get("MaterialPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateMaterial(EntityTestCriteria contraints, Material material) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            material.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            material.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            materialRepository.save(material);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "materialdesc", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "materialdesc", "t7dMtPhRM3oOfutZKCuMM78VdL984c3PC6pQaWSDHgb9VFVI5khPuitunBYDcVZw1"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Material material = createMaterial();
                java.lang.reflect.Field field = material.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(material, null);
                        validateMaterial(contraints, material);
                        failureCount++;
                        break;
                    case 2:
                        material.setMaterialdesc(contraints.getNegativeValue().toString());
                        validateMaterial(contraints, material);
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
