package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class EncodingMain1 {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");

    public static void main(String[] args) {
        System.out.println("=== ASCII 영문 처리 ===");
        encoding("A", US_ASCII);
        encoding("A", ISO_8859_1);
        encoding("A", EUC_KR);
        encoding("A", UTF_8);
        encoding("A", UTF_16BE); // 호환 안됨, 2byte, [0,65] 를 합쳐서 읽는다
        encoding("A", MS_949);

        System.out.println("=== 한글 지원 인코딩 ===");
        encoding("가", EUC_KR); // 2 byte 잘 사용한다
        encoding("가", MS_949); // EUC KR 확장버전
        encoding("가", UTF_8); // UTF_8은 MS_949, EUC_KR 과 호환되지 않는다
        encoding("가", UTF_16BE); // 2byte 사용

    }

    // Charset을 사용하여 문자 인코딩을 실시하는 함수 - "나 이 문자 집합으로 문자열 인코딩 해줘"
    // 인코딩 자체: 문자를 컴퓨터가 이해할 수 있는 숫자(byte)로 변경하는 것 - byte 배열로 변경
    private static void encoding(String text, Charset charset) {
        byte[] bytes = text.getBytes(charset); // 문자 인코딩 결과 숫자가 나오는데, 그걸 바이트로 return 한다. 따라서 String 화 하면 그 숫자를 볼 수 있다
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte\n", text, charset, Arrays.toString(bytes), bytes.length);
    }
}
