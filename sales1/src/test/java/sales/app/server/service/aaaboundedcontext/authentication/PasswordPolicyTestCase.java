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
import sales.app.server.repository.aaaboundedcontext.authentication.PasswordPolicyRepository;
import sales.app.shared.aaaboundedcontext.authentication.PasswordPolicy;
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
public class PasswordPolicyTestCase extends EntityTestCriteria {

    @Autowired
    private PasswordPolicyRepository<PasswordPolicy> passwordpolicyRepository;

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

    private PasswordPolicy createPasswordPolicy() throws SpartanPersistenceException, SpartanConstraintViolationException {
        PasswordPolicy passwordpolicy = new PasswordPolicy();
        passwordpolicy.setMinPwdLength(7);
        passwordpolicy.setAllowedSpecialLetters("HVGEEMfNI3oIXLDCOkuXVPvmap2nPTpOC7QMzZYvlTYiN5NC2m");
        passwordpolicy.setMinCapitalLetters(8);
        passwordpolicy.setMinSmallLetters(1);
        passwordpolicy.setPolicyDescription("9lLasWSM2jxEcj0jSxp0XqkoXG8yfcUarx3NDhORfijZQLZ9ij");
        passwordpolicy.setMinSpecialLetters(11);
        passwordpolicy.setMaxPwdLength(4);
        passwordpolicy.setMinNumericValues(7);
        passwordpolicy.setPolicyName("jyN4mG4AgpE2YqRrghwH06M3FRCxXRJOCWVnRqsosSkbYmqXwD");
        passwordpolicy.setEntityValidator(entityValidator);
        return passwordpolicy;
    }

    @Test
    public void test1Save() {
        try {
            PasswordPolicy passwordpolicy = createPasswordPolicy();
            passwordpolicy.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            passwordpolicy.isValid();
            passwordpolicyRepository.save(passwordpolicy);
            map.put("PasswordPolicyPrimaryKey", passwordpolicy._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordPolicyPrimaryKey"));
            PasswordPolicy passwordpolicy = passwordpolicyRepository.findById((java.lang.String) map.get("PasswordPolicyPrimaryKey"));
            passwordpolicy.setMinPwdLength(8);
            passwordpolicy.setAllowedSpecialLetters("i6fRsGoHLHC5OniRJA7LoYxdOXrmPegzFPz0u4IY1xHEuFKIUL");
            passwordpolicy.setMinCapitalLetters(7);
            passwordpolicy.setMinSmallLetters(11);
            passwordpolicy.setVersionId(1);
            passwordpolicy.setPolicyDescription("wzSdGR2wjp8ZfQ5NVxLLRIGUr30gdkm6uMLKf71faiwzDbAE9S");
            passwordpolicy.setMinSpecialLetters(10);
            passwordpolicy.setMaxPwdLength(10);
            passwordpolicy.setMinNumericValues(4);
            passwordpolicy.setPolicyName("nqpwoECWsy6w5C4TiH3zfdTHUqrRukVnlrirnzfmNHhHxItvB4");
            passwordpolicy.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            passwordpolicyRepository.update(passwordpolicy);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordPolicyPrimaryKey"));
            passwordpolicyRepository.findById((java.lang.String) map.get("PasswordPolicyPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordPolicyPrimaryKey"));
            passwordpolicyRepository.delete((java.lang.String) map.get("PasswordPolicyPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validatePasswordPolicy(EntityTestCriteria contraints, PasswordPolicy passwordpolicy) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            passwordpolicy.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            passwordpolicy.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            passwordpolicyRepository.save(passwordpolicy);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "policyName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "policyName", "fnhEiPISWYvoConscSyJj6kFt4LLeowdjYqw1vzu6ZOis7hDFjrsnmWgxp9kNCWCW9OAdXxnoo1MNQd7ZaWeFDIfZHFzMffDv7RYwMKCBEaNZhvVMO9MJ1eDqy1y9ACRSmmvGUF5HO7wEf4yXaFSHUDgfd5pn6I6cXyCwZPgr3eTnucz5NoiGmVK8KSQvtrb4s1yY1ma02kKrNiyoGu0VkAqo6EU68wnl4iUoCxZIlPCjS7Mp3Rl9Su1oR9BW5Wyv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "policyDescription", "zBt9WVSYwnKzYNLYS1waDtIYQHPPCQZCIBizThMH0KgX5rmeKLFNDeXbZAh73FQcycKCLc5Xhi0t9fsWIc7XwfW6FEapOmteCnClyR6TNLTMYVrc98qOFR0KzlspbAEsJ1YkMENSZOVvMfKJXQU4a1ChKy3bQjDCWoxR9i1ozTG91PvabD8RgHkyPheOdcmLQEs0xcXw40vqv2ZSn9OV5cV0BA9WMezqKQM9WNBPsB10S6j0f3vLl8RbZUKFRdukV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "maxPwdLength", 40));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "minPwdLength", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "minPwdLength", 12));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "minCapitalLetters", 16));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "minSmallLetters", 18));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "minNumericValues", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "minSpecialLetters", 12));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "allowedSpecialLetters", "otB0el4bMU1kKY8iDof8XaqtAOV4UvKzMxLmoaQ8MMQVV78GAvozVujOAcrjn1eYAEHMDfxZBv1tS8njRKAUcH5AJWbKLOK7OC5F2QVqLsMPm9PIpXPenhr05k9f2xvQwAHQGSnewCagV8MSQtsYG3pgXV85qLezMQBrFf6UC7lQuQI0dqlqKUNF5fIGyikRRJixzjpDkVZ8m3QLa8gTIFyb2FwhC60CF57pZmLmObHCKcvpd3pKD8aJxpspLe4BU"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                PasswordPolicy passwordpolicy = createPasswordPolicy();
                java.lang.reflect.Field field = passwordpolicy.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(passwordpolicy, null);
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 2:
                        passwordpolicy.setPolicyName(contraints.getNegativeValue().toString());
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 3:
                        passwordpolicy.setPolicyDescription(contraints.getNegativeValue().toString());
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 4:
                        passwordpolicy.setMaxPwdLength(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(passwordpolicy, null);
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 6:
                        passwordpolicy.setMinPwdLength(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 7:
                        passwordpolicy.setMinCapitalLetters(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 8:
                        passwordpolicy.setMinSmallLetters(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 9:
                        passwordpolicy.setMinNumericValues(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 10:
                        passwordpolicy.setMinSpecialLetters(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validatePasswordPolicy(contraints, passwordpolicy);
                        failureCount++;
                        break;
                    case 11:
                        passwordpolicy.setAllowedSpecialLetters(contraints.getNegativeValue().toString());
                        validatePasswordPolicy(contraints, passwordpolicy);
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
