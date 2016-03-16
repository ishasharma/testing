package sales.app.server.service.organizationboundedcontext.contacts;
import sales.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import sales.app.shared.organizationboundedcontext.contacts.CoreContacts;
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
import sales.app.shared.organizationboundedcontext.contacts.Title;
import sales.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import sales.app.shared.organizationboundedcontext.location.Timezone;
import sales.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import sales.app.shared.organizationboundedcontext.location.Language;
import sales.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import sales.app.shared.organizationboundedcontext.contacts.Gender;
import sales.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import sales.app.shared.organizationboundedcontext.contacts.CommunicationData;
import sales.app.shared.organizationboundedcontext.contacts.CommunicationType;
import sales.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import sales.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import sales.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import sales.app.shared.organizationboundedcontext.location.Address;
import sales.app.server.repository.organizationboundedcontext.location.AddressRepository;
import sales.app.shared.organizationboundedcontext.location.City;
import sales.app.server.repository.organizationboundedcontext.location.CityRepository;
import sales.app.shared.organizationboundedcontext.location.Country;
import sales.app.server.repository.organizationboundedcontext.location.CountryRepository;
import sales.app.shared.organizationboundedcontext.location.State;
import sales.app.server.repository.organizationboundedcontext.location.StateRepository;
import sales.app.shared.organizationboundedcontext.location.AddressType;
import sales.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
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
        Title title = new Title();
        title.setTitles("SEdmgPHHZQ59WOzVLD5GFKswg6PPbH0vgZewmqfAMj8c7GQUyH");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("VSWeHrVR5JisIDs6kgxtd2EC6PZxpxAsPwTWgNwvV3uRZLdMNO");
        timezone.setGmtLabel("ikpiCzNwxjkSZXE8LToJoKdfOmF2OtsWqOB6X41OUXeNJEOdEn");
        timezone.setCountry("jwK6M9a50tijziXt92cBMQgKovkbpDUEmwT6lLwTrSKopqVdEw");
        timezone.setCities("LUoJlX8xj6We1if4KWS5ctfcn06eM31BDZEtnTcs8nuzjAmEQI");
        timezone.setUtcdifference(8);
        Language language = new Language();
        language.setLanguageIcon("7icc2iaXsFWQMZQUzoukI0WJvQFMKfVhzSqhAV8wQ5H8DsxwtE");
        language.setAlpha3("SnM");
        language.setLanguageType("gxEbfV1osxKaKyRoUdfI2eJJNKauoNz8");
        language.setAlpha4("FoQ5");
        language.setAlpha2("mc");
        language.setLanguage("e2HDdWgsWjlokX5BULteGsMM3tba35i8krsaZGeypo5LXUiNpP");
        language.setLanguageDescription("DKlyawAkNyDrwkgCfrkChHhnmBKDDVcsJxA3L10A4nXaDo2tkc");
        language.setAlpha4parentid(7);
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("qOKL75vRF1eRywTncOwHw1vOY959tyM4YcnIqMnC8aQM4eJQqs");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458129743397l));
        corecontacts.setAge(15);
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeMiddleName("PK93CzRzMLkvw7pnOfNwK7WeNLPvogpvOUCDXdaKbgfEDo5SVk");
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458129743461l));
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("xgP9Fwfcykjbz92splLksdb4LNLknhbI06WvwqvHl7y6jAT03a");
        corecontacts.setNativeFirstName("C3RHqIXYnMQAoeqOm7KUumfpif0pgI3lsmsDdSTXSbLwwRIySY");
        corecontacts.setEmailId("wWrUKZKMf1KGBzUsOfbX5AUOFb0DsdIABOnbOzcXPfiWvubp9e");
        corecontacts.setLastName("kgPSzHQlwMAnMZw61cMtqWn9HHJglgkbim9wyoLSpBNKTLacvC");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("6STVXjlIAcczZZUPVDAJg3ScT9LJwZxhnWtouc5XLgYeKIiESt");
        corecontacts.setNativeLastName("zNoAX3nERvcKoOk2a0aBPkuHYDa8kYf5EwjGLvT1dZxIhLkK1l");
        corecontacts.setMiddleName("wTLrbCxqycG32pIWw2Z3eK0wNpl0fNgPLie4Zsv62ZPTL2rA9j");
        corecontacts.setPhoneNumber("hJyRZ5CdmLNlcgCqiPWF");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("Fqf5WLTcED8S4hRdJUipMxlhWpwOylCnx1QtOBuoW6puRcTAGn");
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("aV4ZH4jX5C5UoZsBl1gCKgzrpz5o913Mfhcp4WAKbH1WvsCV9G");
        communicationgroup.setCommGroupName("NFmWKVRT4hOLDY0zAkPbfI8jIxiimOGqcJSxR3saeJAW8WHqrK");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("ZC2USlAW3VDvoVMmK4nwcSF4sX5IMtPTXOcZ3llu1mvzUGqeHZ");
        communicationtype.setCommTypeName("OZX23f5opLtdUByZAUzZz5Usrye0hfXQBVFPvSV9fYVLPwhaYh");
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommData("ZsBZbDSNf91tR2X3fnxgaAi1eAEdWxFmFlQ7gU5EhaegIvxkvq");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        City city = new City();
        city.setCityFlag("H2phLfR3q50Pkgh0xzVXlQLCS10UKVfhBy7Kxuq2uremeE0kh0");
        city.setCityLatitude(3);
        city.setCityDescription("ZmXprYeuzD8JHEcPhpLtTs03BQJYoPxtGLjwITJtMZK4Bbj8sn");
        Country country = new Country();
        country.setCountryCode1("PMA");
        country.setCountryName("zxKSby9FNyP1cJBHunNMVqk99JjcHcpmwelmChlk1UmtcTBBoX");
        country.setCurrencyName("sguiZGrRfp8jOVHrpgLTthAxHwTT3HkkzEuTP0VBOpIpeYsEzk");
        country.setCurrencyCode("RwQ");
        country.setCapitalLatitude(4);
        country.setCapitalLongitude(6);
        country.setIsoNumeric(9);
        country.setCurrencySymbol("CjWxpJ8ZWvvLnOIOrjAmvmQh3moAWSiy");
        country.setCountryFlag("BKqSFNwWm0JBSXHs7aQzVrnHaqEf8nMYmYDChxLUxN4svatG3w");
        country.setCapital("rAiWW0JQHWWpSmYHOkf5zH4MN0hah1Hs");
        country.setCountryCode2("khx");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        State state = new State();
        state.setStateName("mPmbOCbiuCaCY27yuuClzzfrqDHl4zr0ADZA2TsrYQrjOgbJKp");
        state.setStateCodeChar3("7wIIv9fnMs4JhrLMuqG7e3geIn1jPEhI");
        state.setStateName("v1ZGesagEAokhJZ7tksXu0B570HngbAxJrc0wL16eTyOMIXRAq");
        state.setStateCodeChar3("04XZcJCaUzcbEcVajW2vTdL9Ileez12U");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateFlag("XnuH6u216Rh2MdRGWpWU1TtB4Wd7cYftwG5CQ4zqHBCMTm94sE");
        state.setStateCapital("xfI2Q1WbUNq2nbtOKDJjOh53ed5iAUT6OZuQPjAl0UqgyELEfp");
        state.setStateCapitalLatitude(5);
        state.setStateCode(1);
        state.setStateCapitalLongitude(7);
        state.setStateDescription("r59UGffjNtRASkfEYE0UGfSOZeKhQ3HnGN2YMmzCxnGVjidHwQ");
        state.setStateCodeChar2("PKCE2deWbCp83Yf3ECimF7kyZ9RRmjt6");
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        city.setCityFlag("CeJTEPPNcYSvV8g6A8jiDRIBjR6khqMdGJBU2yBelbUdfbbvf8");
        city.setCityLatitude(3);
        city.setCityDescription("n51HxBSJ5UJDZC62JGHb2DzGKgAjFIajaUZ03sFiiYzlMs5Zzg");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("2nzQOVmOxVs7Ks8V3A7IUDHGEAuyAkQmXIXouyklxm8fEh2kkP");
        city.setCityCode(2);
        city.setCityCodeChar2("XtPOyoup2JjZKKcNBr4ClNG8v1fIHvA0");
        city.setCityLongitude(8);
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("x9ylQAmcplRbORrC9OcCoJdJzohA8mtwpn5OBIkRimaKsx4Oqy");
        addresstype.setAddressTypeIcon("jU4QTPIdUctmDVN6Wqhmk7jwHbMIxFSwpAGxnXC5wNvXENSDpy");
        addresstype.setAddressTypeDesc("XeJ6ZWDjRIChGpp5NJrX9GWnvN9Ea1icAiIiYv00DfXuD9gKDI");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("ulF145EZb88rEzvF1GWrKt01pF7fIprDqsQblRPt2UoePQ3JIi");
        address.setAddress2("WYvfdpocWA43nilUwtuc3AQdY6sgdU1YKGDt0PiJeMaJKNo9t8");
        address.setStateId((java.lang.String) StateTest._getPrimarykey());
        address.setZipcode("tthlZ7");
        address.setAddressLabel("O2cY46ps5Iw");
        address.setLongitude("5QDi1Lg2imtX09U9G6tAcsv5GlxxrT3PQr0PQB0Yt8GZl3eH5P");
        address.setAddress1("nQQUnNeDaLF4bVjNRtBACUOGNHULXp0ln7lWvPpBtzcPSk03Qm");
        address.setAddress3("8zrspuh0TS6h574RYx7Y4gOW7yVioLqCDlY9dlMnDcy0Y1cHpx");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
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
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1458129743867l));
            corecontacts.setAge(119);
            corecontacts.setNativeMiddleName("i3Oap0O2ih13NMMIXWdqKhDKYKXmfOyFO2YGRrzXWl6MDJDbkg");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1458129743899l));
            corecontacts.setFirstName("KWuK2ieqQoNiS1PRKoYBfYuqInADrRNnn4OAEHhbN0whFvgxRX");
            corecontacts.setNativeFirstName("fCKniX0BfhHsr9IvEzEiQhQc1xuSbVtZFqsEHhzN61rb7xiIoB");
            corecontacts.setEmailId("VXGfHrij9GCZhvgjuzEg59vrkWVjaXM4NO8hMHXiSOSn86yGos");
            corecontacts.setLastName("ggVoMM5Jr6smGGGxs2Vk9olxopSRmy45mUe2hc1sHjPo3qdUDN");
            corecontacts.setNativeTitle("67D1SduzxQC62GTRgGBFun68ARhc1tAIphbMEEIjjvWLhFZcXS");
            corecontacts.setNativeLastName("YmAwTY5gmOGaIhV98EQWVYWi0upmFRUP6sztGFiJE5Wo4LIeaD");
            corecontacts.setMiddleName("IJJbTfufeuUUNHdHAgJNSxBzNmCHEnxjSf0yrnymBWRaYzXnhv");
            corecontacts.setPhoneNumber("JBb8ye9KJZ8JLAWm4njz");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "TAagNKxT43Eo0eD9dNu76o1WtVuXilfylW5ZSSPqf4QDhPGNKpieKhI4TtZjwPANCSnrfGpvMkJaRE0PBXuryo349GDOZ8RLkmALtRcvRzUFOtgJSa87KJt6l8XVSihUp7MxRqCx4712vOC1dmvGHbrhBYDbyfqvyhQOyFMi3bjsZXGZ3TbsWF3rOwtGZ4eqVGkgLX5hl8jFDGNjkhuPwXypeIL3WGLKIXGZKv4rI6MsuoYWIq2zqf1vIHXW33qPR"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "LHv2lfnKBo8nlhhDn7UVORmTWPpAa1eqkzw6Yc6fpfjqMbVBWYoVzSdmzxxHt6g1SCAry1VJLMEUCrR99OBXDwrsQQASIgWdK9Z4jQIC0RcTJEsrXZVQK2ZZqnVE32pEYoDh7s0d4uv7i2APJbGR8miAPwmH4CacDN6FA6v2QIl4NmKRLgqFyGtfshhc3zCwDwq7CqidIcsZa9HxfQhGngrOmDEcPAqj8atYG7fkcTqpbze40ABzQXx23HIShE3zZ"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "dAfJlFHRcYDybBMeRl1b6cGNzddwgnLXD5sJpHN1qrazEf4rZzvCQP86K0hMad1E3nemKIQrUDHnoOngBI4YR0bbJb5xeN1shBOflhUX19DjqJMIe9dcQKjaZgGex6wufbrR3xnXF0k6RhzvnigG6BnZuZrAnHKIMoqPCXNUoYlQpBTvKqCmZcDICfFLOQO2iVqRMCjzGUHBbmqhheG12zUdF8wbamB7ViYvkblU58Lem2BnIk16ajpyyJTPSjVQo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "XA2rdZXm6aZR0hicGGTOlkGTrJ2vF23dyGBUrfjblwp8m0zRALlGgRvam1QSX5iyR"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "4sCbzYQ90rwRbxtgp5USBnC6UILWmS5SXoLUKnIJbFOibbneXf07LM7HQFNtnZpzPHoGeI158qu80UnYMNzqZpdQyBFFWlmg3lIIf5gjqK1pYbfrJQduUbnGhmpplNu5my3GNhjb21KiVrSEUxOFZe5sIJeGsEKhX0QRq8ajGI9UDHyRKkRjmr370F71OASjnvgN8fLbPIr49HpfO2dBqwUppWufH9KJjbn87lCaYytS7owZz6Z2prusCRy2LeLYn"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "eQfeSws7ofUZan10CDdArLoQEwviuvkY0k0pmCyYgktO7qMXOaKm9DOuP6C0l8FlQnZ2FgM8IRyq2pKtLBC2B1qrMX0iZbCmYMEmcEKlqEuYsHhJIGTSPljkJCNiDiTK5OTlCsXOMie5XiL8togTqvre8vCOfFxbIHNwPcZsDkAPvQERLeTn26dlZFV0NvAKrEatdNx9FQcsFWkTD55yhKPESdw0CWYluiA4SNYq1rnHlkrQhXVSytP8FweHQGfEY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "FgTH9MVoa6FzihrTqSrK8ZNPijTvIJkGihzRPDukeYgOl6ZyltkvP1CYSHJlSSD0OgOC5ZDcWbjVxK5TmLhZAHZxvjYoY5QVbhndw26gSGnWGxsGHliXKRixNefga07eev3UCAkR0NmTXpgt4I7jXh5yVKjsTEWJqHRdDFrGfVhhe4wVAdeJnBC4wViAvrwUQyzbntUwqUL0bXDt0pwSBvwSuinCevvaxoekZqu6wTO2Ysc7tLZ7bBlDaFSAn5UCF"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 156));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "jubDhKaiZgMEMactFDit1KAvKb5gTlsu0zcXVVqk7XxlEApvOIVqx4vdutonq5ZZaj5amRsEKfz5YuOKCw3UC8857mh3JzwTG6tOvndrhvM99RmcCR2ZmToCqhBGEtFxvItvAKl4tpX3YIfe6kv5EtsDx7o4l0O6SMNlCRfMHfsM5cj7ttuwJdoaMpEsQFQU0gLZ59FkmLSIE6qV40ftDmYQmskIRvwxhkKkqcsmkHR7vswxGTjRb9Ucdile2FEQl"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "ngdD7ZFoahPCPd2tuH0W1"));
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
