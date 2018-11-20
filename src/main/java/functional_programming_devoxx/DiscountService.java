package functional_programming_devoxx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
class MemberCard {
    private int fidelityPoints;
}

@NoArgsConstructor
@AllArgsConstructor
class Customer {
    private MemberCard memberCard;

    public Optional<MemberCard> getMemberCard() {
        return Optional.ofNullable(memberCard);
    }
}

class DiscountService {

    private static Optional<Integer> getApplicableDiscountPercentage(MemberCard card) {
        if (card.getFidelityPoints() >= 100) {
            return Optional.of(60);
        } else if (card.getFidelityPoints() >= 50) {
            return Optional.of(10);
        }
        return Optional.empty();
    }

    private static String getDiscountLine(Customer customer) {
        return customer.getMemberCard()
                .flatMap(card -> getApplicableDiscountPercentage(card))
                .map(discount -> "Discount: " + discount)
                .orElse("Discount: " + 0);

    }

    public static void main(String[] args) {

        System.out.println(getDiscountLine(new Customer(new MemberCard(100))));
        System.out.println(getDiscountLine(new Customer()));


    }

}
