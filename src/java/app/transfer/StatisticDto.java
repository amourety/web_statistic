package app.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatisticDto {
    private Long countAllVisitsPeriod;
    private Long countUniqueUsersPeriod;
    //visited more than 10 pages
    private Long countPermanentUsersPeriod;
}
