import { Component } from '@angular/core';

@Component({
  selector: 'app-packages',
  templateUrl: './packages.component.html',
  styleUrls: ['./packages.component.css']
})
export class PackagesComponent {
  travelPackages = [
    {
      destination: 'Bali, Indonesia',
      description: 'Bali is a tropical paradise known for its lush green rice terraces, vibrant local culture, and beautiful beaches. Visit iconic temples such as Uluwatu and Tanah Lot, surf on world-renowned beaches, and immerse yourself in the spiritual essence of this island. Discover hidden waterfalls, indulge in traditional Balinese cuisine, and enjoy relaxing spa treatments.',
      price: 1200,
      imageUrl: 'assets/images/bali.jpg' // Replace with actual image URL
    },
    {
      destination: 'Paris, France',
      description: 'The "City of Lights" is famous for its art, architecture, and romance. Whether you’re exploring the Eiffel Tower, walking along the Champs-Élysées, or admiring the masterpieces in the Louvre Museum, Paris offers an unforgettable experience. Visit Notre-Dame Cathedral, take a cruise on the River Seine, and don’t miss the charming cafés and bakeries serving authentic French pastries.',
      price: 1500,
      imageUrl: 'assets/images/paris1.jpg' // Replace with actual image URL
    },
    {
      destination: 'Tokyo, Japan',
      description: 'Tokyo is a city where ancient traditions meet futuristic technology. From the bustling streets of Shibuya to the serene temples of Asakusa, the city offers a unique blend of experiences. Explore the culinary delights of sushi and ramen, visit the Tokyo Skytree for breathtaking city views, and shop in trendy districts like Harajuku and Ginza. For a peaceful retreat, stroll through the gardens of the Imperial Palace.',
      price: 1800,
      imageUrl: 'assets/images/tokyo.jpg' // Replace with actual image URL
    },
    {
      destination: 'Sydney, Australia',
      description: 'Sydney is a vibrant city known for its iconic landmarks, such as the Sydney Opera House and Harbour Bridge. Relax on Bondi Beach, take a ferry to Manly, or explore the Royal Botanic Garden. The city offers a diverse range of experiences, from fine dining and shopping to outdoor adventures in the nearby Blue Mountains.',
      price: 1400,
      imageUrl: 'assets/images/australia.jpg' // Replace with actual image URL
    }
  ];
  
}
