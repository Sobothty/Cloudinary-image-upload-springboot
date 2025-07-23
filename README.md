# Image Upload Spring Boot Application with Cloudinary

A Spring Boot REST API application that provides image upload functionality using Cloudinary cloud storage service.

## Features

- Upload images to Cloudinary cloud storage
- RESTful API endpoints for image operations
- File size validation (max 5MB per file)
- Secure API key management through configuration
- JSON response with uploaded image URL and timestamp

## Technology Stack

- **Java 21**
- **Spring Boot 3.5.3**
- **Spring Web** - for REST API endpoints
- **Cloudinary SDK** - for cloud image storage
- **Lombok** - for reducing boilerplate code
- **Gradle** - for dependency management

## Prerequisites

- Java 21 or higher
- Gradle 8.14.3 or higher
- Cloudinary account (free tier available)

## Setup

### 1. Clone the repository
```bash
git clone <repository-url>
cd image-upload
```

### 2. Configure Cloudinary credentials

Update the [`application.properties`](src/main/resources/application.properties) file with your Cloudinary credentials:

```properties
cloudinary.cloud-name=your-cloud-name
cloudinary.api-key=your-api-key
cloudinary.api-secret=your-api-secret
```

> **Note**: For production, use environment variables or external configuration files to store sensitive information.

### 3. Build and run the application

Using Gradle wrapper:
```bash
# On Windows
./gradlew.bat bootRun

# On macOS/Linux
./gradlew bootRun
```

The application will start on `http://localhost:8080`

## API Endpoints

### Upload Image

**POST** `/api/image/upload`

Upload an image file to Cloudinary.

**Request:**
- Method: POST
- Content-Type: multipart/form-data
- Parameter: `file` (multipart file)

**Example using curl:**
```bash
curl -X POST -F "file=@/path/to/your/image.jpg" http://localhost:8080/api/image/upload
```

**Response:**
```json
{
  "image_url": "https://res.cloudinary.com/your-cloud/image/upload/v1234567890/sample.jpg",
  "timestamp": "2024-01-15"
}
```

**Error Response:**
```json
"Upload failed: [error message]"
```

## Project Structure

```
src/
├── main/
│   ├── java/com/example/image_upload/
│   │   ├── ImageUploadApplication.java          # Main application class
│   │   ├── config/
│   │   │   └── CloudinaryConfig.java           # Cloudinary configuration
│   │   ├── controller/
│   │   │   └── CloudinaryController.java       # REST controller
│   │   └── service/
│   │       ├── CloudinaryService.java          # Service interface
│   │       └── impl/
│   │           └── CloudinaryServiceImpl.java  # Service implementation
│   └── resources/
│       └── application.properties              # Application configuration
└── test/
    └── java/com/example/image_upload/
        └── ImageUploadApplicationTests.java    # Test class
```

## Key Components

- [`ImageUploadApplication`](src/main/java/com/example/image_upload/ImageUploadApplication.java) - Main Spring Boot application
- [`CloudinaryConfig`](src/main/java/com/example/image_upload/config/CloudinaryConfig.java) - Configuration for Cloudinary client
- [`CloudinaryController`](src/main/java/com/example/image_upload/controller/CloudinaryController.java) - REST endpoints for image upload
- [`CloudinaryService`](src/main/java/com/example/image_upload/service/CloudinaryService.java) - Service interface for image operations
- [`CloudinaryServiceImpl`](src/main/java/com/example/image_upload/service/impl/CloudinaryServiceImpl.java) - Implementation of image upload logic

## Configuration

The application supports the following configuration properties in [`application.properties`](src/main/resources/application.properties):

| Property | Description | Default |
|----------|-------------|---------|
| `spring.servlet.multipart.max-file-size` | Maximum file size for uploads | 5MB |
| `spring.servlet.multipart.max-request-size` | Maximum request size | 5MB |
| `cloudinary.cloud-name` | Your Cloudinary cloud name | - |
| `cloudinary.api-key` | Your Cloudinary API key | - |
| `cloudinary.api-secret` | Your Cloudinary API secret | - |

## Building for Production

### Create executable JAR
```bash
./gradlew build
```

The JAR file will be created in `build/libs/image-upload-0.0.1-SNAPSHOT.jar`

### Run the JAR
```bash
java -jar build/libs/image-upload-0.0.1-SNAPSHOT.jar
```

## Testing

Run tests using:
```bash
./gradlew test
```

## Security Considerations

- Store Cloudinary credentials securely (environment variables, secrets management)
- Implement file type validation
- Add authentication/authorization for production use
- Consider rate limiting for upload endpoints
- Validate file content to prevent malicious uploads

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is available under the [MIT License](LICENSE).
