package com.gelhaimer.mow_it_now.infra;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

class MowItNowCLITest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    public static Stream<Arguments> cliSamples() {
        return Stream.of(
                Arguments.of("garden_5x5_2_mowers.mow",List.of("1 3 N", "5 1 E")),
                Arguments.of("garden_6x5_1_mower.mow", List.of("4 2 E"))
        );
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @ParameterizedTest
    @MethodSource("cliSamples")
    public void execute_mowing_instructions_from_file(String instructionFileName, List<CharSequence> expectedOutput) throws IOException {
        String filePathArgument = toCommandArgument(instructionFileName);

        MowItNowCLI.main(new String[]{filePathArgument});

        Assertions.assertThat(outputStreamCaptor.toString()
                        .trim())
                .containsIgnoringNewLines(expectedOutput.toArray(new CharSequence[0]));
    }

    private String toCommandArgument(String instructionFileName) {
        return Path.of("src", "test", "resources", instructionFileName)
                .toAbsolutePath()
                .toString();
    }


}
