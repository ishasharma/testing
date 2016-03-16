package issuetracker.app.server.businessservice.organizationboundedcontext.contacts;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.CoreContacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CoreContactsBusinessService {

    @Autowired
    private CoreContactsRepository coreContactsRepository;

    public void update(CoreContacts entity) throws SpartanPersistenceException {
        try {
            if (entity.isHardDelete()) {
                coreContactsRepository.delete(entity.getContactId());
            } else {
                coreContactsRepository.deleteAddress(entity.getDeletedAddressList());
                coreContactsRepository.deleteCommunicationData(entity.getDeletedCommunicationDataList());
                coreContactsRepository.update(entity);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    public void update(List<CoreContacts> entity) throws SpartanPersistenceException {
        try {
            for (CoreContacts _corecontacts : entity) {
                if (_corecontacts.isHardDelete()) {
                    coreContactsRepository.delete(_corecontacts.getContactId());
                } else {
                    coreContactsRepository.deleteAddress(_corecontacts.getDeletedAddressList());
                    coreContactsRepository.deleteCommunicationData(_corecontacts.getDeletedCommunicationDataList());
                    coreContactsRepository.update(_corecontacts);
                }
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in updating Entity", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }
}
