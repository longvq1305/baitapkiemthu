import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AppTest {


// --- Các case hợp lệ ---
    static Stream<Arguments> validCases() {
        return Stream.of(
            Arguments.of(2, 5, 5, true, 29312.2),
            Arguments.of(5, 5, 5, false, 32917.5)
        );
    }

    // --- Các case không hợp lệ ---
    static Stream<Arguments> invalidCases() {
        return Stream.of(
            Arguments.of(-1, 5, 5, true, "Quang duong khong hop le"),
            Arguments.of(5, -1, 5, true, "Thoi gian cho khong hop le"),
            Arguments.of(5, 5, -1, true, "Voucher khong hop le")
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
