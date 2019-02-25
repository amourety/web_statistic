package app.transfer;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResultDto {
    private Long countAllVisitDay;
    private Long countUniqueUsersDay;
}
