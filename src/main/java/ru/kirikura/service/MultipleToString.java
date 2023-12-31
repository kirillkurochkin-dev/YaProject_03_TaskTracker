package ru.kirikura.service;

import ru.kirikura.data.Data;
import ru.kirikura.entity.SingleTask;
import ru.kirikura.entity.SubTask;
import ru.kirikura.entity.TaskStatus;
import java.util.ArrayList;
import java.util.Map;

public class MultipleToString {
    public String toOutout(String name, String description, TaskStatus currentStatus, ArrayList<SubTask> subTasks) {
        String border = "═".repeat(20);
        String temp = "\n" +
                "║ Type: " + "MultipleTask" + "\n" +
                "║ Name: " + name + "\n" +
                "║ Description: " + description + "\n" +
                "║ Status: " + currentStatus + "\n" +
                "║ SubTasks: " + "\n" +
                "╚";
        StringBuilder toOut = new StringBuilder(temp);
        for (Map.Entry<Integer, SingleTask> entry : Data.taskGetInstance().entrySet()) {
            if (entry.getValue() instanceof SubTask && subTasks.contains((SubTask) entry.getValue())) {
                toOut.append("\n" + "   ").append(entry.getValue().toString());
            }
        }
        toOut.append("   ╚").append(border).append("╝");
        return toOut.toString();
    }


}
