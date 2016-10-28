//
//  Spot4BooksMap.m
//  genas
//
//  Created by Henadzi Stoma on 10/25/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "Spot4BooksMap.h"


@implementation Spot4BooksMap
{
  NSMutableArray<id<RCTComponent>> *_reactSubviews;
}

static NSString *const kMapStyle =@"["
@"  {"
@"    \"featureType\": \"all\","
@"    \"elementType\": \"geometry\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#242f3e\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"all\","
@"    \"elementType\": \"labels.text.stroke\","
@"    \"stylers\": ["
@"      {"
@"        \"lightness\": -80"
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"administrative\","
@"    \"elementType\": \"labels.text.fill\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#746855\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"administrative.locality\","
@"    \"elementType\": \"labels.text.fill\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#d59563\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"poi\","
@"    \"elementType\": \"labels.text.fill\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#d59563\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"poi.park\","
@"    \"elementType\": \"geometry\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#263c3f\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"poi.park\","
@"    \"elementType\": \"labels.text.fill\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#6b9a76\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"road\","
@"    \"elementType\": \"geometry.fill\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#2b3544\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"road\","
@"    \"elementType\": \"labels.text.fill\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#9ca5b3\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"road.arterial\","
@"    \"elementType\": \"geometry.fill\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#38414e\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"road.arterial\","
@"    \"elementType\": \"geometry.stroke\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#212a37\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"road.highway\","
@"    \"elementType\": \"geometry.fill\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#746855\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"road.highway\","
@"    \"elementType\": \"geometry.stroke\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#1f2835\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"road.highway\","
@"    \"elementType\": \"labels.text.fill\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#f3d19c\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"road.local\","
@"    \"elementType\": \"geometry.fill\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#38414e\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"road.local\","
@"    \"elementType\": \"geometry.stroke\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#212a37\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"transit\","
@"    \"elementType\": \"geometry\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#2f3948\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"transit.station\","
@"    \"elementType\": \"labels.text.fill\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#d59563\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"water\","
@"    \"elementType\": \"geometry\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#17263c\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"water\","
@"    \"elementType\": \"labels.text.fill\","
@"    \"stylers\": ["
@"      {"
@"        \"color\": \"#515c6d\""
@"      }"
@"    ]"
@"  },"
@"  {"
@"    \"featureType\": \"water\","
@"    \"elementType\": \"labels.text.stroke\","
@"    \"stylers\": ["
@"      {"
@"        \"lightness\": -20"
@"      }"
@"    ]"
@"  }"
@"]";

- (instancetype)init
{
  if ((self = [super init])) {
    NSError *error;
    _reactSubviews = [NSMutableArray new];
    GMSMapStyle *style = [GMSMapStyle styleWithJSONString:kMapStyle error:&error];
    self.mapStyle = style;
  }
  return self;
}


- (void) setCenterAndZoom:(NSDictionary *) centerAndZoom {
  if (centerAndZoom!=NULL) {
    CLLocationDegrees lat = [[centerAndZoom objectForKey:@"latitude"] doubleValue];
    CLLocationDegrees lon = [[centerAndZoom objectForKey:@"longitude"] doubleValue];
    float zoom = [[centerAndZoom objectForKey:@"zoom"] floatValue];
    GMSCameraPosition *camera = [GMSCameraPosition cameraWithLatitude:lat
                                                            longitude:lon
                                                                 zoom:zoom];
    [self setCamera:camera];
  }
}


#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wobjc-missing-super-calls"
- (void)insertReactSubview:(id<RCTComponent>)subview atIndex:(NSInteger)atIndex {
  if ([subview isKindOfClass:[Spot4BooksMarker class]]) {
    Spot4BooksMarker *markerObject = (Spot4BooksMarker*)subview;
    GMSMarker *marker = [[GMSMarker alloc] init];
    marker.position = markerObject.coordinate;
    marker.appearAnimation = kGMSMarkerAnimationPop;
    marker.icon = [UIImage imageNamed:markerObject.imageName];
    marker.map = self;
    markerObject.realMarker = marker;
  } else if ([subview isKindOfClass:[Spot4BooksCircle class]]) {
    Spot4BooksCircle *circleObject = (Spot4BooksCircle*)subview;
    GMSCircle *circle = [GMSCircle circleWithPosition:circleObject.coordinate radius:circleObject.radius];
    circle.fillColor = circleObject.fillColor;
    circle.strokeColor = circleObject.strokeColor;
    circle.strokeWidth = 1;
    circle.map = self;
    circleObject.realCircle = circle;
  }
  [_reactSubviews insertObject:subview atIndex:(NSUInteger) atIndex];
}
#pragma clang diagnostic pop


#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wobjc-missing-super-calls"
- (void)removeReactSubview:(id<RCTComponent>)subview {
  if ([subview isKindOfClass:[Spot4BooksMarker class]]) {
    Spot4BooksMarker *marker = (Spot4BooksMarker*)subview;
    marker.realMarker.map = nil;
  } else if ([subview isKindOfClass:[Spot4BooksCircle class]]) {
    Spot4BooksCircle *circle = (Spot4BooksCircle*)subview;
    circle.realCircle.map = nil;
  }
  [_reactSubviews removeObject:subview];
}
#pragma clang diagnostic pop

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wobjc-missing-super-calls"
- (NSArray<id<RCTComponent>> *)reactSubviews {
  return _reactSubviews;
}
#pragma clang diagnostic pop


- (NSString*) getMarkerId:(GMSMarker *) marker {
  NSString* retValue  = @"";
  if (_reactSubviews!=NULL) {
    for (id<RCTComponent> subview in _reactSubviews) {
      if ([subview isKindOfClass:[Spot4BooksMarker class]]) {
        if ([((Spot4BooksMarker*)subview).realMarker isEqual:marker]) {
          retValue = ((Spot4BooksMarker*)subview).identifier;
          break;
        }
      }
    }
  }return retValue;
}


@end
