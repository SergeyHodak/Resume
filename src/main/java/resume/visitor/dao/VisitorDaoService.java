package resume.visitor.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import resume.visitor.model.VisitorModel;
import resume.visitor.repository.VisitorRepository;

@RequiredArgsConstructor
@Service
public class VisitorDaoService {
    private final VisitorRepository visitorRepository;

    public VisitorModel save(final VisitorModel entity) {
        return visitorRepository.save(entity);
    }

    public long howManyVisits() {
        return visitorRepository.count();
    }

    public long howManyReactions() {
        return visitorRepository.howManyReactions();
    }

    public VisitorModel findByIP(final String IP) {
        return visitorRepository.findById(IP).orElse(new VisitorModel());
    }

    public VisitorModel updateByIP(final VisitorModel entity, final String IP) {
        entity.setIP(IP);
        return visitorRepository.save(entity);
    }

    public void delete(final String IP) {
        visitorRepository.deleteById(IP);
    }
}
