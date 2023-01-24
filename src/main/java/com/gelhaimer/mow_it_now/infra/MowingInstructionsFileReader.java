package com.gelhaimer.mow_it_now.infra;

import com.gelhaimer.mow_it_now.domain.Garden;
import com.gelhaimer.mow_it_now.domain.Mow;
import com.gelhaimer.mow_it_now.domain.Orientation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MowingInstructionsFileReader {

    private static final String SEPARATOR = " ";

    public List<Mow> readInstructions(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        Garden garden = toGarden(br.readLine());

        return readCommands(garden, br);
    }

    private List<Mow> readCommands(Garden garden, BufferedReader br) throws IOException {
        List<Mow> commands = new ArrayList<>();

        Mow mowCommand;

        while( (mowCommand = toMowingCommand(garden, br)) != null){
            commands.add(mowCommand);
        }

        return commands;
    }

    private Mow toMowingCommand(Garden garden, BufferedReader br) throws IOException {

        String mowerPositionLine = br.readLine();

        if(mowerPositionLine == null) {
            return null;
        }

        String[] splitPositionLine = mowerPositionLine.split(SEPARATOR);

        return Mow.builder()
                .garden(garden)
                .startAt(Integer.parseInt(splitPositionLine[0]), Integer.parseInt(splitPositionLine[1]), toOrientation(splitPositionLine[2]))
                .mowingInstructions(toInstructions(br.readLine()))
                .build();
    }

    private List<Mow.MowingInstruction> toInstructions(String readLine) {
        return Arrays.stream(readLine.split(""))
                .map(instructionLetter -> switch (instructionLetter) {
                    case "D" ->Mow.MowingInstruction.RIGHT;
                    case "G" ->Mow.MowingInstruction.LEFT;
                    case "A" ->Mow.MowingInstruction.FORWARD;
                    default -> throw new RuntimeException("Unexpected instruction " + instructionLetter);
                })
                .collect(Collectors.toList());
    }

    private Orientation toOrientation(String orientation) {
        return switch (orientation){
            case "N" -> Orientation.NORTH;
            case "E" -> Orientation.EAST;
            case "S" -> Orientation.SOUTH;
            case "W" -> Orientation.WEST;
            default -> throw new RuntimeException("Unexpected orientation " + orientation);
        };
    }

    private Garden toGarden(String line) {
        String[] split = line.split(SEPARATOR);
        return new Garden(
                Integer.parseInt(split[0]),
                Integer.parseInt(split[1])
        );
    }

}
