/*import { useEffect, useState } from "react";
import { Pressable, StyleSheet, Text, View } from "react-native";
import { getThemeMode, setThemeMode, type ThemeMode } from "@/storage/prefs";

export function SettingsScreen() {
  const [mode, setMode] = useState<ThemeMode>("dark");
  const [loading, setLoading] = useState<boolean>(true);

  useEffect(() => {
    let mounted = true;

    async function load() {
      try {
        const saved = await getThemeMode();
        if (mounted) setMode(saved);
      } finally {
        if (mounted) setLoading(false);
      }
    }

    load();

    return () => {
      mounted = false;
    };
  }, []);

  async function toggle() {
    const next: ThemeMode = mode === "dark" ? "light" : "dark";
    setMode(next);
    await setThemeMode(next);
  }

  const bg = mode === "dark" ? "#0d1117" : "#f6f8fa";
  const card = mode === "dark" ? "#161b22" : "#ffffff";
  const border = mode === "dark" ? "#30363d" : "#d0d7de";
  const text = mode === "dark" ? "#c9d1d9" : "#24292f";
  const primary = "#58a6ff";

  if (loading) {
    return (
      <View style={[styles.center, { backgroundColor: bg }]}>
        <Text style={{ color: text, fontWeight: "800" }}>Cargando...</Text>
      </View>
    );
  }

  return (
    <View style={[styles.container, { backgroundColor: bg }]}>
      <Text style={[styles.title, { color: primary }]}>Settings</Text>

      <View style={[styles.card, { backgroundColor: card, borderColor: border }]}>
        <Text style={[styles.label, { color: text }]}>Theme actual:</Text>
        <Text style={[styles.value, { color: text }]}>{mode}</Text>

        <Pressable style={[styles.btn, { borderColor: primary }]} onPress={toggle}>
          <Text style={[styles.btnText, { color: primary }]}>
            Cambiar a {mode === "dark" ? "light" : "dark"}
          </Text>
        </Pressable>

        <Text style={[styles.hint, { color: text }]}>
          Cierra y vuelve a abrir la app: el valor debe persistir.
        </Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 16,
    justifyContent: "center",
  },
  center: {
    flex: 1,
    padding: 16,
    alignItems: "center",
    justifyContent: "center",
  },
  title: {
    fontWeight: "900",
    fontSize: 22,
    marginBottom: 10,
  },
  card: {
    borderWidth: 1,
    borderRadius: 12,
    padding: 14,
  },
  label: {
    fontWeight: "800",
    opacity: 0.85,
  },
  value: {
    fontWeight: "900",
    marginTop: 6,
    marginBottom: 12,
    fontSize: 16,
  },
  btn: {
    backgroundColor: "#21262d",
    borderWidth: 1,
    borderRadius: 10,
    paddingVertical: 10,
    paddingHorizontal: 14,
    alignItems: "center",
  },
  btnText: {
    fontWeight: "900",
  },
  hint: {
    marginTop: 10,
    opacity: 0.85,
    lineHeight: 20,
  },
});*/

import { Pressable, StyleSheet, Text, TextInput, View } from "react-native";
import { useStoredState } from "@/hooks/useStoredState";

const KEY_DISPLAY_NAME = "@settings/displayName";

export function SettingsScreen() {
  const { value, setValue, loading, reset } = useStoredState<string>(KEY_DISPLAY_NAME, "");

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Settings</Text>

      {loading ? (
        <Text style={styles.text}>Cargando storage...</Text>
      ) : (
        <>
          <Text style={styles.label}>Nombre a guardar:</Text>
          <TextInput
            value={value}
            onChangeText={setValue}
            placeholder="Ej: Francisco"
            placeholderTextColor="#8b949e"
            style={styles.input}
            autoCapitalize="words"
          />

          <Text style={styles.preview}>Preview: {value || "(vacío)"}</Text>

          <Pressable style={styles.btn} onPress={reset}>
            <Text style={styles.btnText}>Reset (borrar)</Text>
          </Pressable>
        </>
      )}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#0d1117",
    padding: 16,
    justifyContent: "center",
  },
  title: {
    color: "#58a6ff",
    fontWeight: "900",
    fontSize: 20,
    marginBottom: 16,
  },
  text: {
    color: "#c9d1d9",
    fontWeight: "800",
  },
  label: {
    color: "#c9d1d9",
    opacity: 0.85,
    fontWeight: "800",
    marginBottom: 6,
  },
  input: {
    backgroundColor: "#161b22",
    borderColor: "#30363d",
    borderWidth: 1,
    borderRadius: 10,
    paddingVertical: 10,
    paddingHorizontal: 12,
    color: "#c9d1d9",
    marginBottom: 12,
  },
  preview: {
    color: "#c9d1d9",
    fontWeight: "800",
    marginBottom: 12,
  },
  btn: {
    backgroundColor: "#21262d",
    borderColor: "#58a6ff",
    borderWidth: 1,
    borderRadius: 10,
    paddingVertical: 10,
    paddingHorizontal: 14,
    alignItems: "center",
  },
  btnText: {
    color: "#58a6ff",
    fontWeight: "900",
  },
});