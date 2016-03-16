package sales.app.server.service.aaaboundedcontext.authentication;
import sales.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import sales.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
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
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("AStRnHtbN1EUfIByu5MF9pmfJHjp3FKRD6XXeZ3UgjCGRa90xM");
        useraccesslevel.setLevelIcon("SoGoSEkFBA1e3iRM98b2jcVtIyY0vPpNA7PPuXADAc6IQqhPrP");
        useraccesslevel.setLevelHelp("moBdwVa8I3kVrSxBXM64CP4tXLg2GELdQs2jeW2XeTeKDtgPM5");
        useraccesslevel.setLevelDescription("aJLG8qDD3fN4iaqrGm4M5Bwe9TVtHeHW1MhRiyHt7JWVuYwXb3");
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
            useraccesslevel.setUserAccessLevel(4961);
            useraccesslevel.setLevelName("zmje7bKYbENTcHtQv12v1vQWG5lY2Qd6CRGzPSeItKaJ79LZ8G");
            useraccesslevel.setLevelIcon("edxahNm3V4EMn3Ru2zosvqpWojDcOmjH2J7ctniw8giCFiOKn6");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelHelp("lsK4jWJ4uvzk6c5pn24nvL8nFItY8ieYWIYw3xgqMCZRRUhHOi");
            useraccesslevel.setLevelDescription("8Da99wAHARdb5E3tqntBnOzsYJPt8ub22hzHovZZlcTUKuMIBw");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "userAccessLevel", 196053));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "levelName", "nLHZUP9tickpp0Sslwj891GHiepjH7cr3XJiz8HYut9g2oPpz4UIHTpHDk5nDCLv8AyQYYnKh26hUqYAXPoNUZbTljiGd9JfgZTeYla0kqVjDeRmKA0AKDCRvXj1rgHfTjMrT5EJomGsSyJTld2lnL6YT9rlrNYjEHY8b6WFYvRqUSAYFtTspR0QebaUtWBuCaBe3oNeeyoAaHweoGf8bHqwFvoeFumpZDNvj7gpFhFrUoHFdtqvqXBOuMOWArqco"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelDescription", "HsSpZkTGcC9svLv1ElSnT7SoWMKTaaSkNNLqEIaf6oaQJ7JyCoKQZLCcbmRRHRWMH6mW2IjdajDfkp8LqtB6B4X6sUjkfycpGlE5CXCpT58jvsadBq5iDqPnmWQEUW4r8kuRrOfNn36gmp4GuVqyqQ46iEVfF9fE63CvJAmEr9Uns30T2QzQ4Ni7JJZq4UU92zQNxyspdZSWLBDpM31cWg2J8F4WSaj5bwDbxO0RmRC5RNGOLlmg7SRlIuC0b111H"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "levelIcon", "IDpO8WrFB6LbCe1kqm4z08WstTNFt4MrGpvJBIVPns5QSg2AioHibBZsaVidbsv7IHhFYC1dU60UiRYbe95g2QcvYdeNw3B3OFRY4prQNHSCIWlL4GqIKnM8HzNaeUH59fFPf0W4CH5SoU8LpnmvoldndMJjfhkSxfXHCs73aed1ctD9MsjMF9kWiBl5o4x93VN9ArHi5I6UZKd9hWJwjgwqE8VO0XlrhoLCpUNWPOSGCmkqCzova3W3HLsXuvKPb"));
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
