import { StatusBar } from "expo-status-bar";
import { NavigationContainer } from "@react-navigation/native";
import { AppNavigator } from "@/navigation/AppNavigator";
import { DemoScreen } from "@/screens/DemoScreen";

export default function App() {
  return (
    <NavigationContainer>
      <AppNavigator />
      <DemoScreen />
      <StatusBar style="light" />
    </NavigationContainer>
  );
}