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
import issuetracker.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import issuetracker.app.shared.aaaboundedcontext.authentication.Question;
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
public class QuestionTestCase extends EntityTestCriteria {

    @Autowired
    private QuestionRepository<Question> questionRepository;

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

    private Question createQuestion() throws SpartanPersistenceException, SpartanConstraintViolationException {
        Question question = new Question();
        question.setQuestionDetails("4Y0ShkFIV8");
        question.setLevelid(6);
        question.setQuestionIcon("BAUOR3HewHteFzFwEwBkSodZhNPb7b0xSR7col1YOViSXAgHwt");
        question.setQuestion("F1MJvzhnmDfNMjDSN21B4k5cWZVnv1UUDjdK217R8qssV74kEs");
        question.setEntityValidator(entityValidator);
        return question;
    }

    @Test
    public void test1Save() {
        try {
            Question question = createQuestion();
            question.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            question.isValid();
            questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("QuestionPrimaryKey"));
            Question question = questionRepository.findById((java.lang.String) map.get("QuestionPrimaryKey"));
            question.setQuestionDetails("KXcUQOejQg");
            question.setLevelid(4);
            question.setQuestionIcon("qCyBKOmhXZzuGGgtGbhu1saM6FoKFeHH4XQxAtdbQjLNlsKLwP");
            question.setQuestion("aft9Yiqm1QrW5CQdyaOL5URVx7hzMRpJzAyBJHSJTPIjx1WzYG");
            question.setVersionId(1);
            question.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            questionRepository.update(question);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("QuestionPrimaryKey"));
            questionRepository.findById((java.lang.String) map.get("QuestionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("QuestionPrimaryKey"));
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateQuestion(EntityTestCriteria contraints, Question question) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            question.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            question.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            questionRepository.save(question);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "levelid", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "levelid", 16));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "question", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "question", "Am4kfcHwx0FkjvL79OqNYu4wRb0sZr0WRB5pllJhXPXqVWJT0ljoav8uRY6ARxRDsNAH9zfOwDJmd9PJu3Jicca9q8J3wbxDjCC5l6CjzPmKPfKmnFYsI2TG97QLJA3zTfmnEkEyKzpoe0o5VBlSznjOGzrq2etu63T9AP8H0OZyvyPVikp8oCzYLQu8YhUJGWYV1VcfTND5wbOatPBJ0V0jWiQ8hkoRL96b45KqXhgTtEn5qgXG6E4WAhRctRjH5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "questionDetails", "p"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "questionIcon", "cI6c1HnMV0rmfJXYAnfZkkuTYorUjrAWzQzgHtQknAxcKLWe7HXGsDBFM2QdkuR14"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Question question = createQuestion();
                java.lang.reflect.Field field = question.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(question, null);
                        validateQuestion(contraints, question);
                        failureCount++;
                        break;
                    case 2:
                        question.setLevelid(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateQuestion(contraints, question);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(question, null);
                        validateQuestion(contraints, question);
                        failureCount++;
                        break;
                    case 4:
                        question.setQuestion(contraints.getNegativeValue().toString());
                        validateQuestion(contraints, question);
                        failureCount++;
                        break;
                    case 5:
                        question.setQuestionDetails(contraints.getNegativeValue().toString());
                        validateQuestion(contraints, question);
                        failureCount++;
                        break;
                    case 6:
                        question.setQuestionIcon(contraints.getNegativeValue().toString());
                        validateQuestion(contraints, question);
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
