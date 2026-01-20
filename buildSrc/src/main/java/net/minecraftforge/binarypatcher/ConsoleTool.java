package net.minecraftforge.binarypatcher;

public final class ConsoleTool {
    private ConsoleTool() {
    }

    public static void main(String[] args) throws Exception {
        net.neoforged.binarypatcher.ConsoleTool.main(filterArgs(args));
    }

    private static String[] filterArgs(String[] args) {
        if (args == null || args.length == 0) {
            return args;
        }
        java.util.ArrayList<String> filtered = new java.util.ArrayList<>(args.length);
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if ("--data".equals(arg) || "--unpatched".equals(arg)) {
                if (i + 1 < args.length && !args[i + 1].startsWith("--")) {
                    i++;
                }
                continue;
            }
            filtered.add(arg);
        }
        return filtered.toArray(new String[0]);
    }
}
