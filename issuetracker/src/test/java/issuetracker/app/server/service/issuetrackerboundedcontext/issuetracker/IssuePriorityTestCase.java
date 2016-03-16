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
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssuePriorityRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssuePriority;
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
public class IssuePriorityTestCase extends EntityTestCriteria {

    @Autowired
    private IssuePriorityRepository<IssuePriority> issuepriorityRepository;

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

    private IssuePriority createIssuePriority() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssuePriority issuepriority = new IssuePriority();
        issuepriority.setIssuePriorityDesc("vFoimK1oAKY5aZII3JPfynBt26gxiArteY0E2j04VP2YsXVXCi");
        issuepriority.setIssuePriorityName("BUFUTW1XlCJ7R1bN9ScarW78tfo0F2780Epzkhjfz1YolqzuHj");
        issuepriority.setEntityValidator(entityValidator);
        return issuepriority;
    }

    @Test
    public void test1Save() {
        try {
            IssuePriority issuepriority = createIssuePriority();
            issuepriority.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issuepriority.isValid();
            issuepriorityRepository.save(issuepriority);
            map.put("IssuePriorityPrimaryKey", issuepriority._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssuePriorityPrimaryKey"));
            IssuePriority issuepriority = issuepriorityRepository.findById((java.lang.String) map.get("IssuePriorityPrimaryKey"));
            issuepriority.setIssuePriorityDesc("yDYAOl9PcfzhTfKfvQFi2VQpsyhERi1sOIetTZzGLioafeWo7e");
            issuepriority.setIssuePriorityName("9CVneZfmOrHPPSZJ97CBxDDxmXS3G7t4fbcn3s04DteJKkkIA0");
            issuepriority.setVersionId(1);
            issuepriority.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issuepriorityRepository.update(issuepriority);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssuePriorityPrimaryKey"));
            issuepriorityRepository.findById((java.lang.String) map.get("IssuePriorityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssuePriorityPrimaryKey"));
            issuepriorityRepository.delete((java.lang.String) map.get("IssuePriorityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssuePriority(EntityTestCriteria contraints, IssuePriority issuepriority) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issuepriority.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issuepriority.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issuepriorityRepository.save(issuepriority);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "issuePriorityName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "issuePriorityName", "nExzFXMyds9pPYgpJi0AJRlTmBV0Zl5mL8BJo6MIAyAnIHVtz4DoAoz43syT0qnie7UaoU7nAzjRFyRrb1njTtE4C7dwMP4OZzoUDdz6Trx8JvXsdiggAGZxNBmgMUJ6UjGyqG3wH3lr2Dytb1neLG2LDlw481GwXTrF4gSazjT5K1ZLiwGvhPzJscmsVLw4NJ52xSdeDjx3C2I1SElQTjVJ8b7nqC4GmiI2M6IUKtvKBuSlY9iWbauiAAwoXwHCF"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "issuePriorityDesc", "SgTCVJvjmlYcl9mGHXOjRFIrXxsyQmZ3NBs7mBcmYimfoSQK4yT352LJMkS0l230k74tVlqjFHcCBdtj7Pp1roSAfVG0lsEi5MCZNLuw4MKMc57JiwPF9tA7pVrIRTLTuYBwXneEHKauFigP5tCmEKF2M1SXIwqcyt0C3Yxi9oxamf10NuR45asgsLk89bqs3nTs8FVQ2mWoNUQCoTfwWeLTEakRFtSpfE3QZFmeMtslkmdrcuXHe0dLG4iU082J8hnpyA56pJAaVI2vouw5GgmNzb5OGx89TIdGopWV501yKRJpwjennMjdPpWm48PrqCb9sQvKb8y5LE5IgUD65iDksswSbYZTh1QGCEopZDvZYneePaZCebQdl5ezKXoKZ4Ek9JHEaDTFV0w7TnbV0SmCukVHy0ONO3Oscq6A0SdSg4T0eopaOeOhP85O3J30gohEqYFIFawMLrLfCUakQyYewW72YbBRAdMtXaLEQ1t7HXkC43jh8HE2rSVTJNst4WfnebwcTvOPinxKibh95z8CJ7zD5u39KxPFOGySEIsK498iGGv94jwyPdNstH6xvWkot09d1aSeCETarkmSOIcSQ08uRMZdRRwy8A7iPlfwPuLanTuwrDAEBQllHptoienGdF3xAV2dXZjDj14WqmPtzTZO51YClfcO7tnQmDVjPwDPDS7RUuJQ3w1X52ZXcItmEcLWiljI4N8bBgs95J6buziZHqUUP7koAXvhaItuBaY35kuJoG68MLrZXARpnS0c7aX52zmTlaXXxMFTc4TC9nAHFk0YAYu00v0uHG7TScaQcz6tC4Gc0ZeLJVsFO3UJk0QefSFLSuz1SVC9M5t6H2WGTLbSHQmWoKLZcs378CZSMLXhUVWSyR5ljjq5XOOlgD1bt2JWyh9ZI1gF7z3uUmkkVln1lVDa7Fa9wiADQRbX8N7G3jt3jtvmp6OsWCGnPhPchgzEy0XUp7V7I8cArUN6vZGiY0hynYEVege2Bnar90qKOH7JPb1CBPhoJ"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssuePriority issuepriority = createIssuePriority();
                java.lang.reflect.Field field = issuepriority.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issuepriority, null);
                        validateIssuePriority(contraints, issuepriority);
                        failureCount++;
                        break;
                    case 2:
                        issuepriority.setIssuePriorityName(contraints.getNegativeValue().toString());
                        validateIssuePriority(contraints, issuepriority);
                        failureCount++;
                        break;
                    case 3:
                        issuepriority.setIssuePriorityDesc(contraints.getNegativeValue().toString());
                        validateIssuePriority(contraints, issuepriority);
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
