import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AppTest_DataFlow {


// --- Các case hợp lệ ---
    static Stream<Arguments> validCases() {
        return Stream.of(
            Arguments.of(50, 5, 50, false, 141075.0),
            Arguments.of(50, 5, 50, true, 239827.5),
            Arguments.of(1, 5, 50, false, 9075.0)
        );
    }

    // --- Các case không hợp lệ ---
    static Stream<Arguments> invalidCases() {
        return Stream.of(
            Arguments.of(-1, 5, 40, false, "Quang duong khong hop le"),
            Arguments.of(50, -1, 50, false, "Thoi gian cho khong hop le"),
            Arguments.of(50, 5, -1, false, "Voucher khong hop le")
        );
    }

    @ParameterizedTest
    @MethodSource("validCases")
    void testValidCases(double qd, int tg, int vc, boolean tx, double expected) {
        double actual = App.TinhPhiDichVu(qd, tg, vc, tx);
        assertEquals(expected, actual, 0.01);
    }

    @ParameterizedTest
    @MethodSource("invalidCases")
    void testInvalidCases(double qd, int tg, int vc, boolean tx, String expectedMessage) {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            App.TinhPhiDichVu(qd, tg, vc, tx);
        });
        assertEquals(expectedMessage, ex.getMessage());
    }

}
