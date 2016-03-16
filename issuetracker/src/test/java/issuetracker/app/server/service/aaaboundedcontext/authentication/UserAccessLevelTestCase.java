package issuetracker.app.server.service.aaaboundedcontext.authentication;
import issuetracker.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import issuetracker.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import issuetracker.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import issuetracker.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
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
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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

    private UserAccessLevel createUserAccessLevel() throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("lnxcWsQYnxsxkjRfEEEfMtCf0TV5n6tGTI3Ec441EXZjBQO8w4");
        useraccesslevel.setLevelName("JLMDhkIXZCUSFzWQrHZsnZcCOCAkKCzEcJb2APa36Ad06jZY2s");
        useraccesslevel.setLevelDescription("28mNumR82ybjrTOdSz9JCUXIPKRItfslo0JRilvSiquttBWgqj");
        useraccesslevel.setLevelIcon("dbkiPD5lfP60q5ZOg1arzltBLN7zKdcKJ87KyFH8HU7aHAEEtE");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel();
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setLevelHelp("kVLPnKW7iQczkUHGuP80Br0NKdhZlOTOWlQvhS6xIDAvC0nV4S");
            useraccesslevel.setLevelName("cvos6zT4WFbBRvEi3w5kueD3snbAKlCgRAsoCqgov2d1ha2VSr");
            useraccesslevel.setLevelDescription("cMei7OUM4s2jydeD9HOSZsZEkE3D2r9gbPQreZHJI81Y46LuCJ");
            useraccesslevel.setLevelIcon("if4jAhyAiMKF5MRbL4sn2C8GDhWEAETkrolH9P4j3uNRVEP4XD");
            useraccesslevel.setUserAccessLevel(3254);
            useraccesslevel.setVersionId(1);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 2, "userAccessLevel", ""));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "userAccessLevel", 188144));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "levelName", "9nz2DEOGJ6gc5wUvU3yKzgAdOu92Rala944A8t5LSVOffRZcnqcMMnZ9zMIzO6doKsNevLJwP0wr4sG4ctgNFeY9b9rX8sVNRua7ayxkpNaNHtEjbVmro72ba9g1KcqFNej2MyifsFnofA51ztPKuss7xAd8hKMUOE1ZvLGDc7WMxfAzed58G5SxWrrFG8U1HIof8CFR6nMcUq3fDaIT1Zya4I9X9xhk5E1p17AragBrrCuT6z9mu2DehtB019Lb4"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelDescription", "D5E7yp3J49B5fUYYHHnDSffBKq7Je0pdtmG2VQ3TxhjJFXkf3Ncu1yumEec4OYKqvjXRIkYqs6CisArWhl6kvNDWRHwZTmOzkCXFtXfKOK5z67RIOrKWdzuZolQVxVEWcETL55jXZnQSJshBLcSPT2gjKCc4obq7oefK06s3x5D8UL9bjhXL5IPoKC1UjA86mHXl8w0ce2Clj6PCnhsHZ4DkTV0NSct9ogmlaZ1P9CeuMRU2gI8tXlL05PUjRO98l"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "levelIcon", "sSISIXAmrKpvJNKgwIXn82lwF9nOi1vFYx1FIRbe4imkaGzkCAlU6xZD660yIGiW0u1fK8ZfqcMuYCCU1keyRjHlQhICIiYiOifqgsJKpF11gQ77iDEAXBzMJWpUYHkzXWAs2gPhPerUFdFwpm9xM72asM3AeIvEX7IYAyYBRecAHfMDgAeZtk0Y4LYr3JqkFfKciuDUig6VkZvncWXsLHRDTQhbrmkRwBPzXu4RdZdlQDlkIriWjQoMgpQNKQXrS"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel();
                java.lang.reflect.Field field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
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
