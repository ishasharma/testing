package issuetracker.app.server.service.issuetrackerboundedcontext.issuetracker;
import issuetracker.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import issuetracker.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.FeatureCategoryRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.FeatureCategory;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class FeatureCategoryTestCase extends EntityTestCriteria {

    @Autowired
    private FeatureCategoryRepository<FeatureCategory> featurecategoryRepository;

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

    private FeatureCategory createFeatureCategory() throws SpartanPersistenceException, SpartanConstraintViolationException {
        FeatureCategory featurecategory = new FeatureCategory();
        featurecategory.setFeatureCategoryName("MIgpe3UFqrRqq7NK3hXHaoGmlcP0c9pHKLKH6DBBQThKCuzqFO");
        featurecategory.setFeatureCategoryDesc("XpMHZ1zknZffIcgCZ9pWghlKn84zd0SGyxwxfUdhbwu5KWmzEv");
        featurecategory.setEntityValidator(entityValidator);
        return featurecategory;
    }

    @Test
    public void test1Save() {
        try {
            FeatureCategory featurecategory = createFeatureCategory();
            featurecategory.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            featurecategory.isValid();
            featurecategoryRepository.save(featurecategory);
            map.put("FeatureCategoryPrimaryKey", featurecategory._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("FeatureCategoryPrimaryKey"));
            FeatureCategory featurecategory = featurecategoryRepository.findById((java.lang.String) map.get("FeatureCategoryPrimaryKey"));
            featurecategory.setFeatureCategoryName("W2GHlnxfpPCIjI2JZP1rlesPv76vb9J68GCnalh8ws6aCzT9uh");
            featurecategory.setFeatureCategoryDesc("XHMHMfaFWromRsac8MggUhqO780fpn22XPSoBZkft8lwJvAJbw");
            featurecategory.setVersionId(1);
            featurecategory.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            featurecategoryRepository.update(featurecategory);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("FeatureCategoryPrimaryKey"));
            featurecategoryRepository.findById((java.lang.String) map.get("FeatureCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("FeatureCategoryPrimaryKey"));
            featurecategoryRepository.delete((java.lang.String) map.get("FeatureCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateFeatureCategory(EntityTestCriteria contraints, FeatureCategory featurecategory) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            featurecategory.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            featurecategory.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            featurecategoryRepository.save(featurecategory);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "featureCategoryName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "featureCategoryName", "XjpL3rEERVGRaXWukXGljfFljPNqfQTT5T5tZt1XUGynjQy9qOyk1fqc6xNiDbidvJ2rf41EjxIxChiRsYJvrLHCw3subq6VPMyCrsQ1pJWF2hQbjtOEG4KzQX3Tj0wLIPOJGyswuvxLe7e5dIRMSUaXmBCjCDLfG3fbPCgfwP6BLR97P27uFVOgldk64ztMEA1I2W7u129JGaRkBtD7aFcctubTye1wA9N2iB5KHZypuMvnYS1JxaENKWQhG09A4"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "featureCategoryDesc", "pjb9pcV0VC5sK9Y69h66VElKE0bPR9EKCNSKL9HINWmAYZe18OAgG3zLzT8UTa02ZXBisgJztUYzfVaLNdyz3UUcwy86RQK0ZrCw4Ax7WRZrojDSUAwei5mjUjyEvWaYlVyVj9QQRu8Hvw9cQ2Yfrw9NLy7RzWNy4qeC2p2hdtOn434RHRrH83g8muRCSQBqVxBSTv92NwJSiVwFugC2i10afoJPssZ6BZuRaKls9AGpPD4cQWyb9X3Kq6m7MmrmGohsHM0BUiGDHXstoBmJFnICLN6YUlvUNkCrMjR4dIyl0pCT9ZgzJ3Khnio3qA0stC0PhUvf1RjQOCdcD3fWku2YoZlUYSeZfbwo8JQlLQvxbsRhRONpgvK7IPpiTb3rqJzlEnWNs5Al5RweOMvlqoQRJYnHjeJXagUQDOrpuWhpv08gheE5unWr9iaILEjwcbBEz0xTsE2O1Bsb7B2Ms67HHBoThMfC791VhOLPLYBnfoFOapeGZ0j5vJgLn73ua8LuwIrrYIc2whSf1eVYpMKZgoJvOkSnAJZcE5IjIikOVAHGHHKUSazFJB90IO23pB8a8aKhrro7ELUdf71xc6MTdBzJhSdK4OLJs4jdayjeMK1WqUF3THZ1DOAJbXLeQ44aDMeJQSBN7OXJIdlB7qPuRe5bs1jvYQWyFXRg0pNj9m5isjPzYnSGMhD8C7aN1PqFFNeFrJUeZPWDJcsQ7iOUojEzxhWakdsRCQDG8JcmTYyWSk1wwbwIH2YysZ9LHOdxouykPaGi8K3OkkGet7ODFfGojMpBVr0F5PUJrLV8lpBlG10XaTUf8HP5aF8wBR5RE50FpqhoDSQe0DgqaX2zhcSuNotd7Lls6k0sdDjfdllXznXU3ltfAYE7kxwS373EBbULYboqRIfw273WP2Labe3LI9ZK6dbW6m24QQAPMO2y2w8XMiWcGLRgPOPP27wFTXyw4HmOYbovSDuZEPbv0Or23g8yC3niL7dZabBQr4VrOWYJGt81jDyIC8qXx"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                FeatureCategory featurecategory = createFeatureCategory();
                java.lang.reflect.Field field = featurecategory.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(featurecategory, null);
                        validateFeatureCategory(contraints, featurecategory);
                        failureCount++;
                        break;
                    case 2:
                        featurecategory.setFeatureCategoryName(contraints.getNegativeValue().toString());
                        validateFeatureCategory(contraints, featurecategory);
                        failureCount++;
                        break;
                    case 3:
                        featurecategory.setFeatureCategoryDesc(contraints.getNegativeValue().toString());
                        validateFeatureCategory(contraints, featurecategory);
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
