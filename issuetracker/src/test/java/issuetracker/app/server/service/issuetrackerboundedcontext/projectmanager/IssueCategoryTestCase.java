package issuetracker.app.server.service.issuetrackerboundedcontext.projectmanager;
import issuetracker.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import issuetracker.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.IssueCategoryRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.IssueCategory;
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
public class IssueCategoryTestCase extends EntityTestCriteria {

    @Autowired
    private IssueCategoryRepository<IssueCategory> issuecategoryRepository;

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

    private IssueCategory createIssueCategory() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueCategory issuecategory = new IssueCategory();
        issuecategory.setIssueCategoryName("bUU4MGnr19M07knn7Ou6NEQNrJEnoqNis9xsOUEe0wKdchKGEm");
        issuecategory.setIssueCategoryDesc("PpZ6KaQ0wN4WMptWBUPixdCw4K3FuEFrlQ3XWYVLk84cL9YuFB");
        issuecategory.setEntityValidator(entityValidator);
        return issuecategory;
    }

    @Test
    public void test1Save() {
        try {
            IssueCategory issuecategory = createIssueCategory();
            issuecategory.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issuecategory.isValid();
            issuecategoryRepository.save(issuecategory);
            map.put("IssueCategoryPrimaryKey", issuecategory._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueCategoryPrimaryKey"));
            IssueCategory issuecategory = issuecategoryRepository.findById((java.lang.String) map.get("IssueCategoryPrimaryKey"));
            issuecategory.setVersionId(1);
            issuecategory.setIssueCategoryName("OVa406RXxUS0cd0og02m6RfUfgsXjq5xRQ7H1bjXIEiiNkQm1V");
            issuecategory.setIssueCategoryDesc("JQDUHKl422iCcfPMz1VAAxXmwAmO35eWRooDglZF6bBPNy9gdl");
            issuecategory.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issuecategoryRepository.update(issuecategory);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueCategoryPrimaryKey"));
            issuecategoryRepository.findById((java.lang.String) map.get("IssueCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueCategoryPrimaryKey"));
            issuecategoryRepository.delete((java.lang.String) map.get("IssueCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueCategory(EntityTestCriteria contraints, IssueCategory issuecategory) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issuecategory.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issuecategory.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issuecategoryRepository.save(issuecategory);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "issueCategoryName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "issueCategoryName", "JsE3J07wZhrb8K57nDD6vVIWyeeMMC1OwxG79oBpI4gjF1VdE7FzSsY59GDS9Jzdoq3miIUVZLFcoFzH1oify8BIBybtJNG7pC4I9GbSzrQojMkTESlhwHVHBMvGLe2DLg4nzCHBz1wclKzhtmBZw0Q7RPzX2dvD6vkL4xaatyCtMBQ1GXemNfCUqsUptQwVjrnE6fGwIoQZc6BNfy8tnEtIWs3T6ua2B5cwO8UdqwNeaDt6a42AvjrWqaKFIw1si"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "issueCategoryDesc", "PxIq8chWodpImMhjfHkEaRiCjVMvANovfnPAZDC0kCgADMQ8uFyrhL17XDKWq7I9XJhxcS8rWOWPWqp2zoqP95lNFxIJXRO2p5jB9cUfhbhkcdq5M1l1iXKQ6P0pfxpRWTFvikeolFbdzNTKXxQKEArk4qg4mJLYQ2kmnfxS4r1h5cXO8H0gThKd1LMQwx6JiHdn2AjDbYWsIfyHMpV2r83VGKh6nzAqjPaqMMIhXtyvgQdm555WzKsCx56YVBJezIc91OVwYimDzjGG4UAVv9naz3sOexoVNgU30CUw6hvHi77tul54vt9r9XBvvbSyLUPXkhbXBgHTPlbhE9QJHNFfF9qeeXbvX7gNiuUvIsX8kpqeJOF1fFWSMVyBJZZaYJBD9g2Fom4ZHD4e7ut4Q6O58kRulW2abimeFDfjVlrrccvs1WTCCrPC3F9eRYWTavwjNDlCXjViU0hTWT8WtYxEqM5TJ1EAYb2jxypybIIA5CJBg15Xnne3q8Rdq4mBigjGbq70TuMKJBYxwC4coW26Z0F5iYOUJnGfCkRcmdA6SQeIMJwIDOvTCg5ZQ1l9AtroqCUPDvRaagJQ7RbuPXI52zPWoZdtiul4yB0imp4mWEHGhoip4hZHMh0aH8221metBjfLgOGqOHwYM9QKG8S1tU02Ajxl6QX6W8qcEWJrqsl69hL2JkUrcqlUdf3VIt9LCtv59r9jo2dnyaUuMbjRV3qdi4XWyvk8feoEEIHs4JDpcewjPKRdXFMa6Q56DNIWaGdrHKP97g1hrW4DdZpHHRduh2CVxsRAnOliH4bGrrQZ5Fkj22bf0aOEKyKbvqLT84AXwSxiyeh3LNjVoCzWdisnmiQSBLfIbQqOQc6xeAkprJURkHEfmBhKWAMOJQMjw0ocgfxO9svNi03WBfUKohm2Pa25VGVOst4kZeHDtMXNYWzgZub6yco0pqlB1t62jHBQvvsLEEUkyHrP3M2MbKmMVNjoSii8VFXtBozPdRcuxUjgdpTeOI9zFnwuq"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueCategory issuecategory = createIssueCategory();
                java.lang.reflect.Field field = issuecategory.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issuecategory, null);
                        validateIssueCategory(contraints, issuecategory);
                        failureCount++;
                        break;
                    case 2:
                        issuecategory.setIssueCategoryName(contraints.getNegativeValue().toString());
                        validateIssueCategory(contraints, issuecategory);
                        failureCount++;
                        break;
                    case 3:
                        issuecategory.setIssueCategoryDesc(contraints.getNegativeValue().toString());
                        validateIssueCategory(contraints, issuecategory);
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
