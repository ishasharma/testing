package issuetracker.app.server.service.aaaboundedcontext.authorization;
import issuetracker.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import issuetracker.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import issuetracker.app.server.repository.aaaboundedcontext.authorization.UserRoleBridgeRepository;
import issuetracker.app.shared.aaaboundedcontext.authorization.UserRoleBridge;
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
import issuetracker.app.shared.aaaboundedcontext.authentication.User;
import issuetracker.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import issuetracker.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import issuetracker.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import issuetracker.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import issuetracker.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import issuetracker.app.shared.aaaboundedcontext.authentication.PassRecovery;
import issuetracker.app.shared.aaaboundedcontext.authentication.Question;
import issuetracker.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import issuetracker.app.shared.aaaboundedcontext.authentication.UserData;
import issuetracker.app.shared.aaaboundedcontext.authorization.Roles;
import issuetracker.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserRoleBridgeTestCase extends EntityTestCriteria {

    @Autowired
    private UserRoleBridgeRepository<UserRoleBridge> userrolebridgeRepository;

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

    private UserRoleBridge createUserRoleBridge() throws SpartanPersistenceException, SpartanConstraintViolationException {
        User user = new User();
        user.setChangePasswordNextLogin(1);
        user.setPasswordAlgo("5p9w0rhdidNgTJ8dmIxKsYzBB4llwotuzSs3wMv95EDr35CYQN");
        user.setGenTempOneTimePassword(1);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("c9hSxIQjjc3YwXZ7KgGpU3DAL99PniH3J2kY20set1Ybqzfq9d");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("SrEpq820rmWhSQcZyxQyQy04jLXGBfxA7tpiEFqptNscDhlARY");
        useraccessdomain.setDomainName("L7eWMYeQcyRfjs6fJuhwseeuTRuQAEk1cBer8qNqNKtn3jWcaV");
        useraccessdomain.setDomainDescription("ZlBqt3zLtgUy0LdI4yv07PaGNYdmEG1Vi15wlkjaBbCybmeouk");
        UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
        map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("DzW1kCidQOvDz8eGECzHByln3A8WYoSdr2xcyJDoPW4FY5V7RF");
        useraccesslevel.setLevelName("kerQ5KJa3nla6oULusALuoacM293x5jcRMGgsimYU1g2QcSrPk");
        useraccesslevel.setLevelDescription("qmm0ofy8cEIkYF9zLfbcfdepUtssLTTeArXV8eWEtQ6vPx4xoZ");
        useraccesslevel.setLevelIcon("yO3qgd1tqrk7mGnkC6QDVuLVoL9zbwxuCLNwvtPybeOIGQwVrI");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
        map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        user.setChangePasswordNextLogin(1);
        user.setPasswordAlgo("T2gVO1SMe5TNdwG2pFWxQwqUCZMt13S2Ba1aCPHDKF35wXB7qv");
        user.setGenTempOneTimePassword(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setAllowMultipleLogin(1);
        user.setMultiFactorAuthEnabled(1);
        user.setIsDeleted(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1458127865921l));
        user.setIsLocked(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordExpiryDate(new java.sql.Timestamp(1458127865945l));
        user.setSessionTimeout(640);
        user.setUserAccessCode(39634);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionDetails("qxnejvjxs7");
        question.setLevelid(7);
        question.setQuestionIcon("QeY0F2ZdYnav1wrpoFxInLhfXNZcP2qK8E6bnuz2sjhWl7Zc5f");
        question.setQuestion("YYGYgDr4PVvvOrBA2yGG6GkML7z4LoJuA7yC3a83IrlMFYsQev");
        Question QuestionTest = questionRepository.save(question);
        map.put("QuestionPrimaryKey", question._getPrimarykey());
        passrecovery.setUser(user);
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        passrecovery.setAnswer("VgCqhEQLS8286SBN9zyHERMClgx4zSZjqROWMzMUKZzCj7LdHN");
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordExpiry(11);
        userdata.setLast5Passwords("aA42PiMQA6hM5IAQ1oQNbE8UcTkUn1OdMWKaeZ8vhLSeGqlKF0");
        userdata.setOneTimePasswordExpiry(6);
        userdata.setLast5Passwords("yUMapAb4POO92VXODMgkaE3mbfZiWCx0IEwMbqBollq2pYJRcC");
        userdata.setUser(user);
        userdata.setPassword("9Ly7dbBHUK7yzF1YBCutJgoqvUnfM1Uf5qsHlAp0YgBxcqzMWa");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1458127866086l));
        userdata.setOneTimePassword("MOkMtDUX4WKV4sjsOjH4SvTwGmCh7oxg");
        user.setUserData(userdata);
        User UserTest = userRepository.save(user);
        map.put("UserPrimaryKey", user._getPrimarykey());
        Roles roles = new Roles();
        roles.setRoleHelp("nAwoydeYUM3CnY7XCSe0etZLaSOjHPuG5J7PCgpjaPLAsU1TOp");
        roles.setRoleDescription("3bt4HBx0PA0o0AKyo2NhjSQlNyZ8geo1mLyNDcA4dz3tR9TmmO");
        roles.setRoleName("MDTWx3JBHx7ZfYW9RysvhDVNLlU8hUVi0LVjrAqX2pyH95IOkb");
        roles.setRoleIcon("Luv6jHFEhg69nQWYVBRExHx2v7fJvKW5SjQOt2G0yEnn96ZcSp");
        Roles RolesTest = rolesRepository.save(roles);
        map.put("RolesPrimaryKey", roles._getPrimarykey());
        UserRoleBridge userrolebridge = new UserRoleBridge();
        userrolebridge.setUserId((java.lang.String) UserTest._getPrimarykey()); /* ******Adding refrenced table data */
        userrolebridge.setRoleId((java.lang.String) RolesTest._getPrimarykey());
        userrolebridge.setEntityValidator(entityValidator);
        return userrolebridge;
    }

    @Test
    public void test1Save() {
        try {
            UserRoleBridge userrolebridge = createUserRoleBridge();
            userrolebridge.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            userrolebridge.isValid();
            userrolebridgeRepository.save(userrolebridge);
            map.put("UserRoleBridgePrimaryKey", userrolebridge._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private RolesRepository<Roles> rolesRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserRoleBridgePrimaryKey"));
            UserRoleBridge userrolebridge = userrolebridgeRepository.findById((java.lang.String) map.get("UserRoleBridgePrimaryKey"));
            userrolebridge.setVersionId(1);
            userrolebridge.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            userrolebridgeRepository.update(userrolebridge);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<UserRoleBridge> listofuserId = userrolebridgeRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
            if (listofuserId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("UserRoleBridgePrimaryKey"));
            userrolebridgeRepository.findById((java.lang.String) map.get("UserRoleBridgePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByroleId() {
        try {
            java.util.List<UserRoleBridge> listofroleId = userrolebridgeRepository.findByRoleId((java.lang.String) map.get("RolesPrimaryKey"));
            if (listofroleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("UserRoleBridgePrimaryKey"));
            userrolebridgeRepository.delete((java.lang.String) map.get("UserRoleBridgePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserRoleBridge(EntityTestCriteria contraints, UserRoleBridge userrolebridge) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            userrolebridge.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            userrolebridge.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            userrolebridgeRepository.save(userrolebridge);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
    }
}
