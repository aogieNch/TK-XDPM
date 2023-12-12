package pm02.cameraWebSeller.id_generator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
public class IdGenerator implements IdentifierGenerator {

    private String prefix;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        if (object.getClass().isAnnotationPresent(CustomId.class)) {
            CustomId customIdAnnotation = object.getClass().getAnnotation(CustomId.class);
            return customIdAnnotation.prefix() + generateRandomId();
        }
        throw new IllegalArgumentException("Class does not have the @CustomId annotation: " + object.getClass().getName());
    }

    private final Set<String> idSet = new HashSet<>();
    private String generateRandomId() {
        Random random = new Random();
        String randomId;
        do {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < 8; i++) {
                int digit = random.nextInt(10);
                stringBuilder.append(digit);
            }
            randomId = stringBuilder.toString();
        } while (!idSet.add(randomId));
        return randomId;
    }
}
