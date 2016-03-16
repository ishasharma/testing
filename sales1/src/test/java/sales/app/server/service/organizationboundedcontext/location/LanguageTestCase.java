package sales.app.server.service.organizationboundedcontext.location;
import sales.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import sales.app.shared.organizationboundedcontext.location.Language;
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
public class LanguageTestCase extends EntityTestCriteria {

    @Autowired
    private LanguageRepository<Language> languageRepository;

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

    private Language createLanguage() throws SpartanPersistenceException, SpartanConstraintViolationException {
        Language language = new Language();
        language.setLanguageIcon("vThVbmhIPwzd2jdqmjSHBz256WMgtpVEEsdFpBFMX4o3PFyPkG");
        language.setAlpha3("X2U");
        language.setLanguageType("42KT9rKDAHd1mSiszwpCOwA9lkAqdCCT");
        language.setAlpha4("dufn");
        language.setAlpha2("QN");
        language.setLanguage("FjK6KTEG8AxrxgbIUvhNOuoDUcVWwpxbbnXauMRumjWrVr3j3V");
        language.setLanguageDescription("t95CtzPlVgyl4igVt5XRpZQu25XUGRAvj9O9yDEHJEl8ArJ1sc");
        language.setAlpha4parentid(3);
        language.setEntityValidator(entityValidator);
        return language;
    }

    @Test
    public void test1Save() {
        try {
            Language language = createLanguage();
            language.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            language.isValid();
            languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LanguagePrimaryKey"));
            Language language = languageRepository.findById((java.lang.String) map.get("LanguagePrimaryKey"));
            language.setLanguageIcon("aJWlLkVQckAxCEdllVhNMKp01oEju6HCNuVbRNAdM1LqL0tXOf");
            language.setVersionId(1);
            language.setAlpha3("2wG");
            language.setLanguageType("SKxk5QY6Lr0LzLv3YXxTDts5DkWIkSTz");
            language.setAlpha4("9m4m");
            language.setAlpha2("rj");
            language.setLanguage("JMIOIYx0IV1g7tyti939kzufpO3ZfreYaxRbb3XWFczaKkfGTg");
            language.setLanguageDescription("0TVP6a6W0ACNvH8tEGs0yOyscnqCFdOzodTUKq4HcefaMEiMaT");
            language.setAlpha4parentid(3);
            language.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            languageRepository.update(language);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LanguagePrimaryKey"));
            languageRepository.findById((java.lang.String) map.get("LanguagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LanguagePrimaryKey"));
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLanguage(EntityTestCriteria contraints, Language language) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            language.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            language.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            languageRepository.save(language);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "language", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "language", "FfFXee7Jb5mcfiv0zR8ZNguLdi6AAvfvKsTo0zTk6XwTGQWymzuuglQ9ITC8rV4O7ZMTTGiapY3srlLT3o6L916FqJwMYvf1qqF2osAjVGKCtssQ6mNAwKzOUCRwQ66K2zl07RsI41SegHJq9Ljj6dlckGzxh8QNWq4yI12XcqNNWNC1ixRWgxbFmio28ta24d9jw58Ej1b22BMHCD4Nn9OiQgZgYScbTgGjyHWt5LMPXYxwCOLLG98bjZ1zryj1a"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "languageType", "jSUBzMXFVnqI2dflkll9nJ8x6qnEgPdWJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "languageDescription", "dPuyIbkzd3OpYBOqYodCAQAlLfu2HkDKFKXIU1aSmNvY6ONwDUAnJmRLF6rzfen5nwoevUt7s5v42bQLz5XmUwCXhUOoQAOUpSayn8fwI659KSZnVrfBlIcfyPWW91xMgGxVc5A3M4WBYt0t6L0bY8zdhj53mU4H6HnpPmLM5Zlj8hXHCofTfdBtiymMP0JN5ZuZBqSpkgnCiCAHWTJiTI4fES6ff2La0BXOmnGuLq25jQU5RlfAQnw5sY0vTtSBp"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "languageIcon", "3FtVV1Vn0beEcxLsIvWwCyr3FOljguNHARVqFNE0yV0D56DW2QmH0jSqJT66MyEolLx0jvBcC6lyHZFf3jPpAjzfg0TU5K4zo6mvRKhbjE3lSCHMSkpX4t2PCF8A6Wkfe"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "alpha2", "rUS"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "alpha3", "4l5v"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "alpha4", "W4fBP"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "alpha4parentid", 18));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Language language = createLanguage();
                java.lang.reflect.Field field = language.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(language, null);
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 2:
                        language.setLanguage(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 3:
                        language.setLanguageType(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 4:
                        language.setLanguageDescription(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 5:
                        language.setLanguageIcon(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 6:
                        language.setAlpha2(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 7:
                        language.setAlpha3(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 8:
                        language.setAlpha4(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 9:
                        language.setAlpha4parentid(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLanguage(contraints, language);
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
