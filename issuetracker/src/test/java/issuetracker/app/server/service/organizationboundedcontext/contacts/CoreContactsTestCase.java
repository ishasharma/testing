package issuetracker.app.server.service.organizationboundedcontext.contacts;
import issuetracker.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import issuetracker.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.CoreContacts;
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
import issuetracker.app.shared.organizationboundedcontext.location.Timezone;
import issuetracker.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.Title;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.Gender;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import issuetracker.app.shared.organizationboundedcontext.location.Language;
import issuetracker.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import issuetracker.app.shared.organizationboundedcontext.location.Address;
import issuetracker.app.server.repository.organizationboundedcontext.location.AddressRepository;
import issuetracker.app.shared.organizationboundedcontext.location.Country;
import issuetracker.app.server.repository.organizationboundedcontext.location.CountryRepository;
import issuetracker.app.shared.organizationboundedcontext.location.City;
import issuetracker.app.server.repository.organizationboundedcontext.location.CityRepository;
import issuetracker.app.shared.organizationboundedcontext.location.State;
import issuetracker.app.server.repository.organizationboundedcontext.location.StateRepository;
import issuetracker.app.shared.organizationboundedcontext.location.AddressType;
import issuetracker.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationData;
import issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationType;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase extends EntityTestCriteria {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    private CoreContacts createCoreContacts() throws SpartanPersistenceException, SpartanConstraintViolationException {
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("wGZTjcclc8fEH6Rp3Qym5buhhEaLfbGmKLApfl9CxfE357py0T");
        timezone.setTimeZoneLabel("e5P6fXP0JWRtYIZRqHluUFMEb2grr0rJgjFRqHzb4TcuCufmNI");
        timezone.setCountry("zWlFyJxadPmRJaRBY03d8TYM0jZ7XG47uUnwq5b6h8OUQFYkSK");
        timezone.setCities("4O1JyTMGxpwooeNlhaiYaLtgmoicHWi8GILWRsjSXqWSczDCN3");
        timezone.setUtcdifference(11);
        Title title = new Title();
        title.setTitles("26dY1XHI2nZPSXMZd1W1Bj6QSuUWW4GzpHGEq2QJtlhsk8ViuJ");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("tAOVFYxGjiOtzsn3q6anlIbmi1WxyDX9QQ7lGBDGwV5AoqpWOn");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setLanguage("ZyjFyesO95FaulYLVrTuzUTbiMgfUovkGlHYjUkGcMvixNv6s3");
        language.setAlpha4parentid(3);
        language.setAlpha2("mU");
        language.setLanguageIcon("vtIuFVAv7mS5HIprVOsXxKDWz4SI8reybfycvbJpQfFDsryl6f");
        language.setAlpha4("xItO");
        language.setAlpha3("w0z");
        language.setLanguageType("R2IMDKWV0WTMwbIsWKeMqUOBZFbAinLJ");
        language.setLanguageDescription("nljgZHksvUm2HBQG638zP4sft8WBenLkqvesEiVGdtwW1y7umI");
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setFirstName("QMgEkDMNCLoR6qzzKzZ5GrT9n76SSatf6iYXHvCarwpA6u0Yxb");
        corecontacts.setMiddleName("AhLfIjAUUKd1v7UMyCHwCERydB1NVlvLSpoITuzxDb4TaYxdSM");
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setNativeLastName("fXM7F6o5UiL9PlRKfAoA9bMZmltPel624CgutmarIypWQEhO26");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458127851114l));
        corecontacts.setAge(77);
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("cWxlzBNGpae7NhmPS0AUtPTBW9kdveGopnHx1Ct89Na0ZxyyYL");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("4xMpbMXeUEcHMZ1gsLd1Opk0lCdTSB53znOozVyLLjULj6TeAX");
        corecontacts.setPhoneNumber("AXfuknwyG7ukKpVtk0Wf");
        corecontacts.setEmailId("o12KWeJ8Dwc8S1jqwZjD2S1piuCRSSCYzkYzjbluVMfZWK163E");
        corecontacts.setNativeMiddleName("eXrloJbotYTsjpCtNrp67u7mT4UFpsgPGODhtFKjHgjVxBBWr1");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458127851217l));
        corecontacts.setNativeTitle("ffdLgpmNnG5pHf4ylH8X1hMD6yXMsLgH5pJIDxNkBKCSrNYwJk");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        Country country = new Country();
        country.setCountryName("DSz9YaD7jPZTdlRGVbXFreEk1JWPGq61MLM5kJAPqn0i1HQ1JV");
        country.setCountryCode1("7Cy");
        country.setCapitalLongitude(10);
        country.setCurrencyName("vcJkFVuz6MtVuxVkc48ZqOPytUP2rH2Obruy94k3booGuYZeAT");
        country.setCurrencyCode("bw3");
        country.setCountryFlag("T0c2yECBRlypt2Umqvmz0P5Mb7z1joHdB13oLJ8MUCYpwLcQGl");
        country.setIsoNumeric(6);
        country.setCapitalLatitude(9);
        country.setCapital("reGd67lkR1ETj8p6As7qb5rK01UO4HB6");
        country.setCountryCode2("3LS");
        country.setCurrencySymbol("iG3UAEHM7fpgyYgYXBvPr5uNG9ci9kCY");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        City city = new City();
        city.setCityFlag("uggYR4pBk2RtTjghvGQlCPFDwvlRnSrPnjLIAEgoAyCiHUNJ6K");
        city.setCityLongitude(1);
        city.setCityLatitude(10);
        city.setCityDescription("7vQsNuoq7Fx4hbvzntm0YvaOxlg3a6dg4hF7wduwwVveiCapTc");
        city.setCityCode(2);
        city.setCityName("mNTufcr48fOBKXYoAf4sDxYdfDgSQJZvVhXYZb5P0g7ywUYfWf");
        State state = new State();
        state.setStateCodeChar2("5CpqBQl3YQxHd58LLBD0TeTp4uVqhBXR");
        state.setStateCapitalLongitude(5);
        state.setStateCodeChar3("3efjaJAMJAUj84w3iO03kX31Z8awKimC");
        state.setStateCodeChar2("0FZQ8GRj6Z6lBVtCYAMbghjg5xkV4a2h");
        state.setStateCapitalLongitude(8);
        state.setStateCodeChar3("QAlFr77daJj8d2xNmQ9intTWdNNRExW6");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("RkT288HsQbEJHbH02se19BaXHUraTXXPNB4idW9SttpaAciDzM");
        state.setStateFlag("9QgSnncHqLP8aJwm8mAt2OHGnnYLj2e5e0ojhOgb1fEXRj0PNO");
        state.setStateCapital("8WHvLxv9N0dE5H3jeqBH0V8uYVX6JJdCnXt42hheZUP8DcKJiw");
        state.setStateCapitalLatitude(8);
        state.setStateDescription("fN3XRqBIT6HBu0L37P65ncY1mVzhFpNTeG8SRoX5cBneHpl2m6");
        state.setStateCode(1);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        city.setCityFlag("TW9SMgGq2NC4qtnNORctwzl1MsLDC2IIJQQfDIliAGQRBkLrnw");
        city.setCityLongitude(6);
        city.setCityLatitude(8);
        city.setCityDescription("eX4fSSCDlynLTb7geDyqdYcJJGdUwemxvesljnORPNovxl5s2s");
        city.setCityCode(3);
        city.setCityName("U4Nbw9BZ1FYn3qoUvxJLHNDYQVAmnDpJBrHFaakc398BqYuuyF");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("1C3u7Z4XDm4NYouuIB3kOjAkZWxg3tcx");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("usakL6k4PprhBzBeS2D2T3xwnwsEP6DOR3xVdFmBCoswkOd0f0");
        addresstype.setAddressTypeDesc("jiwEGgxytpJFGxzDebxpzDPMYLyqtzYEwgM9A5AnMqOX8ENRmE");
        addresstype.setAddressType("UuB0FUVcvTSKH9qoTGYOHCDAGIYG0T9Llt5DIs7R8RrDnMHanz");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("bTPKUc3jk1rlnd2KstDO6QAvGqxIQypmCIymRdvkT4iSIa5BJD");
        address.setAddress1("ZRsJjWnB2oLuhmD8WVaj1PmLFIQ3lj5e5q7ckk98R3wIMEqPYl");
        address.setLatitude("cNk156fKqic6OVMYyUnNXEFG3A8Yn1v8Vvic9hbnQooi5JDf0L");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("9xOk9W");
        address.setAddress2("3iNT3f0UXd0LcItaYscIfEg03YIAS4YoirYCmsjdJyz6PLDsnK");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("w456l4lrjDc");
        address.setAddress3("dIaFv73pMXtfkPHcl9SDla8YDr0vYl0dYlCm6hzeTf7vTvgvT1");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("WEPuMT4B64VafAuVPBSJ8ChB3CRs6otBMG4fVP8Eu2QUe5OL4h");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("yzBEthgM44wyU6XE2ZvYwgwn4L458zUOsxaaQlvhCqySuYVeny");
        communicationgroup.setCommGroupName("ApQhz4BWfL9Xt7jGVvBU60rnR16cG9I17j7Cd4Ihc8LQ1qBL5N");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("fbcewciXCwDZpW1o08TlXMCVgFfPVfeWIQ3OA13jah2w5KhAaN");
        communicationtype.setCommTypeName("WcNUag6uFJ4sHX40OMpmHCWZvSN2gTavQOgHxzWV9FtdAKbKrc");
        communicationtype.setCommTypeDescription("PWq6TUw4cqX0VNsK3D2wSCpAatWKwYjKHlJjC126yBxtm1sxK4");
        communicationtype.setCommTypeName("ITjCP9hAOYsYazkpHVFUEXXwrOE5S1uZdU9NxikHt5rZjeGQ3Y");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommData("bOdHrPlcC8yuGOKG6AFQMfHRhnPk70JAS9tPH0WLiQ3Wy6rgwE");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts();
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setFirstName("m7G8V0XErcYBChch8dNQklSkXmvZadVLRgkJKzSOqUsmUpVbJT");
            corecontacts.setMiddleName("rYCrULncEuDVTeRAJxakMMN7uLPPVkD9FnnnkBfIQV7rqxDngn");
            corecontacts.setNativeLastName("g8yJy9eHVWsAefZqQLluNRBJSntGdPdqGx2lE5eEhzPIMhdNrl");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1458127851576l));
            corecontacts.setAge(93);
            corecontacts.setLastName("MkXC37ZQ2gEzbPTnjWonkXTMafai0jyEQBXrBPrJbJwZdDw1er");
            corecontacts.setNativeFirstName("ojGTFMKJMzcvTAwsZKklI4PYZNhpfrKsSMUhTMBB4YGO9P9zQ6");
            corecontacts.setPhoneNumber("IgjkxwA0ATTdnWHI26cI");
            corecontacts.setEmailId("2pvZEDhIosuxVQMQmexSA4Yt5GNHQGFNqEC8FsuUvFTGDMjIQJ");
            corecontacts.setNativeMiddleName("vfnhYnjZMADEpYA8pZBimYFQ11Z5IN0JM447VbAaJljYXd3EWY");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1458127851627l));
            corecontacts.setNativeTitle("McjhQIjEXxhUCb0h3qVz1rHeDAv7o38Ecdfr1LySkjwiN7mINX");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            corecontactsRepository.save(corecontacts);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "firstName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "ShRPCibGaj0b2QfsG4oFWVMUlZ1VV2IG3LEWsfUockNgQwV0EJMcK1QRy2bP9v0fDo80cX8R2on1Ea4WcYYUIeCNZsqMqND0ZXqL4yJtBkX6kcwA6Djf0yAh7dtwhtTgVs88IRJdttJrRp5HRocrhmuEAeLZCJM1LYlTQIv6h7biOztSgCarRPIq99DpQ5cIhRLcgtIJrdsxD4Krts4R1H8InzK25r67SqTXJJ1rSf2IGX67JlTHNYyHgr5fvVaEX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "cFoQKvS1ImZbmvf7JeKjswkqyPvN6dNVeCYoxGldhBrBPEehtElEPGCYrE2IV1b06rQI6UdTfCgfcVVZWg0HwYRRKypG2RoopZgI1L0PpMWdeJze2qCKrtAMzk3XPdntCqdsgmvXnQTL9wjAKPHPwV0x3U0qusFvT4m130IlsBNmjXPAHry7UPb06cZv9vH4fqTPFLcyTGvVB8WHlJZKJpw0QyzcX4L5FVLCSSjMK47aF1PTxtnTIwjyt1yuZ48TD"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "FFhB3XcDe1Nu0PvCs9NTw9MCZGO3w9Ikirwi8HwjvZM05pd4Tfh6WYGaQt0bODwdvddDkH7KcqylsBaeTtxxBca6lValgbQ4d1p5N8MYSUMDfOFRDEFeJII8ZlDneKj4PTTcSA5TRA44wxsGg3TC4QOdRfMQKVcibkaOrblIAjqzvNHtxI9eozFWqlSErelVMKpbWkMI34BNAPpObWu2Z1mvPhShcUwpep1Cl51i1e82JVTbTOSB7HHPv4BSDiiV5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "rd58NWEi1tgFMzJYCIwiWu79G1f9cKQcN20YQTJHeIliDmyD9sOqWoxYAkuYFoETv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "VcBDqst3V3xfFqBdYFRcmgkrmyhpc8mAHzkPoDV4ZTi3uMRHtP0DvvkYLPWQDj8PCbHMCBWLrdoDZnTslcaWXGA2JpqwA5MJZjIXDFlFZqZGXSUDtPDW643jezZRTVnfUttFUIHqHcfH3qEeGvQ6Xch2rbriJyyN9Lj5t8J5Khq3NdRok7B8LkBLgzuDX8sC9G4KBRMNAhw3LVwnb52LOthU9OsDNaMKWsvLi1HLp0nMejjXTOOOJirbdGbPQLSFN"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "Z3v1zPmFdnVFcQq5fHEU0aXS17YoHTJzn2GBRooc7kcttWUGC6ctJyuIqEjpPH57vORI3XQgGoQYnMw01paOWzA9BgcbuV7SuZ9dCAAxEhMsuj8feSdristRkXKSPLK339qwzu21Nli1FQy5RXKsVOhArFIw4mDEOqfWfVbmDO1pXsw7Z8q3ixVfuUhsAKNdFaCGKKVYLY2s0E6ysxy2mbZ48Is3M8xAGbDNTU9JXLOpJaVkzq1PNbVTiUVbKaNJ0"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "dZa96OoaiaK1877QKFdW3R1yWZS7B46ivTX6OqhYNneKxi87XvaGB3OGn2JJCK5ZGLaFI5YVn6UxVcwlQEjleXKUGUNFQLhGM5L5RW0yJ1ifkNrYHjlmSjcUPVJEYGI9YTFt8pkZJDMq53BuATUeg4zJbnHHrV6cKfkHJSQal1FfurgZ6wUkCeh0v1TJg1opBFjocbqjd6CHo3RMzTSQA9cNHtsyhdK6rQiImugPWJjiWFTpMX7H3sXSvOB7Os6LN"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 199));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "92KSFXwREFfdB2CmTp7zkZlFLGjKNWEJAYNznkinIl9mZCKzC5vWBmCJUciHqwSny4fJALGDOLskkIpxGA2F8KwAWJibombhWhWh7qez1pVGExTSyuwTvGt9kGE9nBKpK1o3xwe34Ev9zfZmf33RIC9CpQiTLxt1oPdezY0f3hvgtmXVE0tcCgpdukaeGmGDHrFYLIdk1qCAWWlxmWaWn99M4DiVyuHnHL6YdQ8fnqqYS4IXVziWFkvM0vX906edE"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "FGbZOn04mnYqr4SkG7Ymv"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts();
                java.lang.reflect.Field field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 2:
                        corecontacts.setFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 3:
                        corecontacts.setMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 5:
                        corecontacts.setLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 6:
                        corecontacts.setNativeTitle(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 7:
                        corecontacts.setNativeFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 8:
                        corecontacts.setNativeMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 9:
                        corecontacts.setNativeLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 10:
                        corecontacts.setAge(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 12:
                        corecontacts.setEmailId(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 14:
                        corecontacts.setPhoneNumber(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
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
