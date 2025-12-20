@Service
public class InteractionServiceImpl implements InteractionService {

    private final InteractionCheckResultRepository repository;

    public InteractionServiceImpl(InteractionCheckResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public InteractionCheckResult checkInteractions(List<Long> medicationIds) {
        InteractionCheckResult result = new InteractionCheckResult();
        result.setInteractions("NO_RULE_CHECK_YET");
        result.setCheckedAt(java.time.LocalDateTime.now());
        return repository.save(result);
    }
}
