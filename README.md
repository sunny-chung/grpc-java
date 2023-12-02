gRPC-Java - An RPC library and framework
========================================

This is a patch, for fulfilling specific inspection requirement, of the [gRPC-Java](https://github.com/grpc/grpc-java) project.

Usage
-----

```kotlin
implementation("io.github.sunny-chung:grpc-netty-shaded:1.59.1-patch1")

configurations.all {
   resolutionStrategy.eachDependency {
      if (requested.group in setOf("io.github.sunny-chung", "io.grpc") && requested.name in setOf("grpc-core", "grpc-api", "grpc-netty", "grpc-netty-shaded")) {
         if (requested.version == grpcVersion) {
            useTarget("io.github.sunny-chung:${requested.name}:$grpcVersion-patch1")
            because("transport inspection")
         }
      } else if (requested.group == "io.grpc" && requested.name.startsWith("grpc-") && requested.version?.startsWith("$grpcVersion-patch") == true) {
         useVersion(grpcVersion)
         because("not built")
      }
   }
}
```
