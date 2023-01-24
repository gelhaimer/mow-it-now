package com.gelhaimer.mow_it_now.infra;

import com.gelhaimer.mow_it_now.domain.InvalidStartingPosition;
import com.gelhaimer.mow_it_now.domain.Mow;
import com.gelhaimer.mow_it_now.domain.MowerPosition;
import com.gelhaimer.mow_it_now.domain.MowingService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class MowItNowCLI {

    public static void main(String[] args) throws IOException {
        MowingService mowingService = new MowingService();
        MowingInstructionsFileReader mowingInstructionsFileReader = new MowingInstructionsFileReader();

        List<Mow> commands = mowingInstructionsFileReader.readInstructions(new FileInputStream(args[0]));

        commands.forEach(command -> {
            try {
                MowerPosition mowerPosition = mowingService.execute(command);
                print(mowerPosition);
            } catch (InvalidStartingPosition e) {
                throw new RuntimeException(e);
            }
        });

    }

    private static void print(MowerPosition mowerPosition) {
        String coordinates = mowerPosition.coordinate.x + " " + mowerPosition.coordinate.y;
        String orientation = switch (mowerPosition.orientation) {
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };

        System.out.println(coordinates + " " + orientation);
    }

}
